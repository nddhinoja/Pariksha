package org.nirr.examinationrestservice.dao;

import org.dippy.models.Exam;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl{
    //@Override
    /*public List<Exam> retriveQuestionPaper(String subject) {

        List<Exam> examList = new ArrayList<>();
        examList.add(new Exam("What is your name?","A","B","C","D"));
        examList.add(new Exam("What is your birthdate?","a","b","c","d"));
        examList.add(new Exam("What is your college name?","AA","BB","CC","DD"));
        examList.add(new Exam("What is your experience?","aa","bb","cc","dd"));

        return examList;
    }*/

    //@Override
    public Double calculation(List<Exam> examList) {
        return 12.5;
    }
}
