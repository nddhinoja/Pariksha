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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    UserService userService;

    @PostMapping("/examinitial")
    public ModelAndView examStart(Exam exam, HttpSession session){
        String output;
        Exam examOutput = new Exam();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        exam.setExamDate(String.valueOf(now));
        exam.setUser((User) session.getAttribute("wholeuser"));
        exam.setSubject(exam.getSubject());

        List<Question> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();

        try {
            HttpPost httpPost = new HttpPost("http://localhost:8080/ExaminationRestService_war/examinitial");
            httpPost.addHeader("content-type","application/json");
            String examJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(exam);
            StringEntity examEntity = new StringEntity(examJson, ContentType.APPLICATION_JSON);
            httpPost.setEntity(examEntity);

            HttpResponse response = defaultHttpClient.execute(httpPost);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            while ((output= bufferedReader.readLine())!=null){
                examOutput = mapper.readValue(output,Exam.class);
            }
        }catch (Exception e){e.printStackTrace();}
        session.setAttribute("examId",examOutput.getExamId());
        session.setAttribute("subject",exam.getSubject());
        ModelAndView modelAndView = new ModelAndView("exampage");
        modelAndView.addObject("question",examOutput.getQuestionList());
        return modelAndView;
    }

    @PostMapping("/result")
    public ModelAndView examResult(@RequestParam("questionId") List<Long> questionIds, HttpServletRequest request,
                                   HttpSession session){
        ModelAndView modelAndView = new ModelAndView("result");
        System.out.println(session.getAttribute("examId"));

        List<StudentPaper> listStudentPaper = new ArrayList<>();
        for(Long questionId:questionIds){
            StudentPaper studentPaper = new StudentPaper();
            studentPaper.setQuestionId(questionId);
            String id = request.getParameter(String.valueOf(questionId));
            Long id1 = Long.valueOf(id);
            studentPaper.setSelectedAnswer(id1);
            listStudentPaper.add(studentPaper);
        }
        Result result = new Result();
        result.setExamId((Long) session.getAttribute("examId"));
        result.setList(listStudentPaper);

        ObjectMapper mapper = new ObjectMapper();
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        String output;
        Double resultOfExam = 0.0;

        try{
            HttpPost httpPost = new HttpPost("http://localhost:8080/ExaminationRestService_war/result");
            httpPost.addHeader("content-type","application/json");
            String resultJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
            StringEntity entity = new StringEntity(resultJson, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);

            HttpResponse response = defaultHttpClient.execute(httpPost);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            while ((output=bufferedReader.readLine())!=null){
                resultOfExam  = Double.parseDouble(output);
            }

        }catch (Exception e){e.printStackTrace();}

        modelAndView.addObject("marks",resultOfExam);
        return modelAndView;
    }
}
