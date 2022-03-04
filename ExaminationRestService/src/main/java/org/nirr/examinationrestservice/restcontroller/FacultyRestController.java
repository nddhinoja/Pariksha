package org.nirr.examinationrestservice.restcontroller;

import org.dippy.models.Exam;
import org.dippy.models.Question;
import org.nirr.examinationrestservice.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FacultyRestController {

    @Autowired
    FacultyService facultyService;

    @PostMapping("/savequestion")
    public void saveQuestion(@RequestBody Question question){
        facultyService.saveQuestion(question);
        System.out.println("RestController:Question saved");
    }

    @PostMapping("/viewquestionbank")
    public List<Question> viewQuestionBank(@RequestBody Exam examSubject){
        List<Question> listOfQuestion = facultyService.retriveQuestionBank(examSubject);
        return listOfQuestion;
    }

    @GetMapping("/allstudentdata")
    public List<Exam> allExamDetailsWithStudentName(){
        List<Exam> examList = facultyService.retrieveStudentDataOfExam();
        return examList;
    }

}
