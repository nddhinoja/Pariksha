package org.nirr.examinationrestservice.dao;

import org.dippy.models.Exam;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FacultyDaoImpl{

    public void saveQuestion(Exam exam) {
        System.out.println("DAO:Question data saved");
    }

    /*public List<Exam> retriveQuestionBank(String subject) {
        List<Exam> listOfExam = new ArrayList<>();
        List<String> answerOption = new ArrayList<>();
        answerOption.add("A");answerOption.add("B");answerOption.add("C");answerOption.add("D");
        Exam question1 = new Exam("Maths","What is your name?","A","B","C","D","D","1.5");
        listOfExam.add(question1);
        Exam question2 = new Exam("","What is your birthDate?","A","B","","D","C","1");
        listOfExam.add(question2);
        Exam question3 = new Exam("","What is your spouse name?","AA","B","C","D","D","2.5");
        listOfExam.add(question3);
        Exam question4 = new Exam("","Where are you living?","AA","BB","C","D","C","1");
        listOfExam.add(question4);
        return listOfExam;
    }*/
}
