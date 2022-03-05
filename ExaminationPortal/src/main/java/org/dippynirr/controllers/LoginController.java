package org.dippynirr.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.dippy.models.*;
import org.dippynirr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.util.*;

@Controller
@SessionAttributes("login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ModelAndView showLoginPage(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("login",new Login());
        return modelAndView;
    }

    @PostMapping("/loginprocess")
    public ModelAndView loginProcess(@ModelAttribute("login")Login login, HttpSession session) throws IOException {
        ModelAndView modelAndView = null;
        String output ;
        User user = null;
        ObjectMapper mapper = new ObjectMapper();
        DefaultHttpClient httpClient = new DefaultHttpClient();

        try {
            HttpPost postRequest = new HttpPost("http://localhost:8080/ExaminationRestService_war/user/loginvalidate");
            postRequest.addHeader("content-type","application/json");
            String loginJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(login);
            StringEntity loginEntity = new StringEntity(loginJson, ContentType.APPLICATION_JSON);
            postRequest.setEntity(loginEntity);

            HttpResponse response = httpClient.execute(postRequest);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            while ((output = bufferedReader.readLine()) != null) {
                System.out.println(output);
                user = mapper.readValue(output,User.class);
            }
        }catch (ClientProtocolException e){e.printStackTrace();}

        if(user!=null){
            if(user.getUserCategory().contains("Student")){
                modelAndView = new ModelAndView("studentdashboard");
            }
            else if (user.getUserCategory().equals("Faculty")){
                modelAndView = new ModelAndView("facultydashboard");
                List<User> list = new ArrayList<>();
                List<Exam> examList = new ArrayList<>();


                try{
                    HttpGet httpGet = new HttpGet("http://localhost:8080/ExaminationRestService_war/allstudentdata");
                    HttpResponse response = httpClient.execute(httpGet);
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(response.getEntity().getContent()));
                    while ((output=bufferedReader.readLine())!=null){
                        examList = mapper.readValue(output, new TypeReference<List<Exam>>() {});
                    }
                }catch (Exception e){e.printStackTrace();}

                List<Exam> studentDataWithExamResult = new ArrayList<>();
                for(Exam exam:examList){
                    if(exam.getMarks()!=null){
                        studentDataWithExamResult.add(exam);
                    }
                }
                modelAndView.addObject("displayData",studentDataWithExamResult);
            }
            modelAndView.addObject("exam",new Exam());
            modelAndView.addObject("message","You are all set!!");
            session.setAttribute("user",user.getName());
            session.setAttribute("wholeuser",user);
        }
        else {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("message","Your username or password is wrong!!Try again..");
        }
        return modelAndView;
    }

    @PostMapping("/emailverifying")
    public ModelAndView emailVerifyer(@ModelAttribute Email emailId){
        ModelAndView modelAndView = null;
        String output;
        User user = null;
        ObjectMapper mapper = new ObjectMapper();
        DefaultHttpClient httpClient = new DefaultHttpClient();

        try{
            HttpPost httpPost = new HttpPost("http://localhost:8080/ExaminationRestService_war/user/emailvalidate");
            httpPost.addHeader("content-type","application/json");
            String emailJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emailId);
            StringEntity emailEntity = new StringEntity(emailJson, ContentType.APPLICATION_JSON);
            httpPost.setEntity(emailEntity);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(httpResponse.getEntity().getContent()));
            while ((output = bufferedReader.readLine())!=null){
                user = mapper.readValue(output,User.class);
            }
        }catch (Exception e){e.printStackTrace();}

        //User user = userService.validateEmail(emailId);

        if(user!=null){
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("message","mail sent!!");
        }
        else {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("message","Wrong mail Id");
        }
        modelAndView.addObject("login",new Login());
        //modelAndView.addObject("email",new EmailId());
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registrationProcess(){
        ModelAndView modelAndView = new ModelAndView("registrationform");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @ModelAttribute("login")
    public Login login(){
        return new Login();
    }

    //JSON to Object and Object to JSON
    //ObjectMapper mapper1 = new ObjectMapper();
    //Login login111 = new Login("Dippy","Nirr");
    //String abcd = mapper1.writerWithDefaultPrettyPrinter().writeValueAsString(login111);
    //System.out.println(abcd);
    //Login login2 = mapper1.readValue(abc,Login.class);
    //System.out.println(login2.getUserName()+login2.getPassword());

    //reading JSON file demo
    //InputStream inputStream = new FileInputStream("/Users/dipalidhinoja/Desktop/Examination-Project/Login.json");
    //Login login3 = mapper.readValue(inputStream,Login.class);
}
