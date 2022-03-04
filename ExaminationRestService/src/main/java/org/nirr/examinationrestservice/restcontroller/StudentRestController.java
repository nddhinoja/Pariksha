package org.nirr.examinationrestservice.restcontroller;

import org.dippy.entities.ExamTblm;
import org.dippy.entities.QuestionTblm;
import org.dippy.models.Exam;
import org.dippy.models.Question;
import org.dippy.models.Result;
import org.dippy.models.StudentPaper;
import org.nirr.examinationrestservice.dao.ExamDao;
import org.nirr.examinationrestservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentService studentService;
    @Autowired
    ExamDao examDao;

    public StudentRestController(StudentService studentService, ExamDao examDao) {
        this.studentService = studentService;
        this.examDao = examDao;
    }

    @PostMapping("/examinitial")
    Exam retriveQuestionPaper(@RequestBody Exam exam){
        Exam savedExam = studentService.createExam(exam);
        return savedExam;
    }

    @PostMapping("/result")
    Double result(@RequestBody Result resultObject){
        Double marks =  studentService.calculation(resultObject);
        return marks;
    }

    @GetMapping("/test")
    void test(){
        examDao.saveResult(14.0,1L);
    }

    @PostMapping("/testexam")
    String testExam(@RequestBody Exam exam){
        ExamTblm examTblm = new ExamTblm(exam.getExamId(),exam.getExamDate(),exam.getSubject());
        ExamTblm examTblm1 = examDao.save(examTblm);
        return "All saved check it ;-)";
    }
}
