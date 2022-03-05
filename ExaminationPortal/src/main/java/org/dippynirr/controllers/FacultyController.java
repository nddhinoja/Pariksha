package org.dippynirr.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("subject1")
public class FacultyController {

    @Autowired
    UserService userService;

    @PostMapping("/setquestion")
        public ModelAndView setQuestionPaper(@ModelAttribute("subject1") Exam examSubject, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("setquestions");
        Question question = new Question();
        modelAndView.addObject("exam",question);
        session.setAttribute("subject",examSubject.getSubject());
        return modelAndView;
    }

    @PostMapping("/savequestion")
    public ModelAndView saveQuestion(@RequestParam("questionContent")String content,@RequestParam("correctanswer")String selectedAnswer,
                                     @RequestParam("weightage")Double weightage,
                                     HttpServletRequest request, @SessionAttribute("subject1") Exam examSubject,
                                     HttpSession session){
        Exam exam = new Exam();
        Question question = new Question();
        question.setQuestionContent(content);
        question.setQuestionSub(examSubject.getSubject());
        List<Option> list = new ArrayList<>();
        Option optionA = new Option(request.getParameter("optionA"));list.add(optionA);
        Option optionB = new Option(request.getParameter("optionB"));list.add(optionB);
        Option optionC = new Option(request.getParameter("optionC"));list.add(optionC);
        Option optionD = new Option(request.getParameter("optionD"));list.add(optionD);

        if(selectedAnswer.equals("A")){optionA.setFlag(true);}
        else if(selectedAnswer.equals("B")){optionB.setFlag(true);}
        else if(selectedAnswer.equals("C")){optionC.setFlag(true);}
        else if(selectedAnswer.equals("D")) {optionD.setFlag(true);}

        question.setWeightage(weightage);
        question.setOptionList(list);

        ModelAndView modelAndView = new ModelAndView("setquestions");

        ObjectMapper mapper = new ObjectMapper();
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();

        try{
            HttpPost httpPost = new HttpPost("http://localhost:8080/ExaminationRestService_war/savequestion");
            httpPost.addHeader("content-type","application/json");
            String examJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(question);
            StringEntity questionEntity =new StringEntity(examJson, ContentType.APPLICATION_JSON);
            httpPost.setEntity(questionEntity);

            HttpResponse response = defaultHttpClient.execute(httpPost);
            BufferedReader bufferedReader = new BufferedReader(
                   new InputStreamReader(response.getEntity().getContent()));

        }catch (Exception e){e.printStackTrace();}
        modelAndView.addObject("exam",new Question());
        modelAndView.addObject("message","Previous Question is saved");
        return modelAndView;
    }

    @PostMapping("/viewquestions")
    public ModelAndView viewQuestionBank(@ModelAttribute("viewSubject") Exam subjecExam){
        ModelAndView modelAndView = new ModelAndView("viewquestionbank");

        String output;
        List<Question> questionList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();

        try{
            HttpPost httpPost = new HttpPost("http://localhost:8080/ExaminationRestService_war/viewquestionbank");
            httpPost.addHeader("content-type","application/json");
            String examJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(subjecExam);
            StringEntity examEntity =new StringEntity(examJson, ContentType.APPLICATION_JSON);
            httpPost.setEntity(examEntity);

            HttpResponse response = defaultHttpClient.execute(httpPost);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            while((output= bufferedReader.readLine())!=null){
                questionList = mapper.readValue(output, new TypeReference<List<Question>>() {});
            }

        }catch (Exception e){e.printStackTrace();}

        modelAndView.addObject("subject",subjecExam.getSubject());
        modelAndView.addObject("questionlist",questionList);
        return modelAndView;
    }

    @ModelAttribute("subject1")
    Exam exam(){
        return new Exam();
    }
}
