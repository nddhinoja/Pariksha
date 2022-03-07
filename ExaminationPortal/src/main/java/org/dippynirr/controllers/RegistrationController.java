package org.dippynirr.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.dippy.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
@SessionAttributes("user")
public class RegistrationController {

    @PostMapping("/successfullregistration")
    public ModelAndView afterRegistration(@ModelAttribute("user") User user){
        String output = null;
        String nameOfUser = null;
        ObjectMapper mapper = new ObjectMapper();
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try{
            HttpPost httpPost = new HttpPost("http://localhost:8080/ExaminationRestService_war/user/successfullregistration");
            httpPost.addHeader("content-type","application/json");
            String userJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
            StringEntity userEntity = new StringEntity(userJson, ContentType.APPLICATION_JSON);
            httpPost.setEntity(userEntity);

            HttpResponse response = defaultHttpClient.execute(httpPost);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            while((output= bufferedReader.readLine())!=null){
                nameOfUser = output;
            }
        }catch (Exception e){e.printStackTrace();}

        ModelAndView modelAndView = new ModelAndView("afterregistration");
        modelAndView.addObject("name",nameOfUser);
        modelAndView.addObject("message","You are all set now!!");
        return modelAndView;
    }

    @ModelAttribute
    public User user(){
        return new User();
    }
}
