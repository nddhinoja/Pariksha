package org.dippynirr.services;

import org.dippy.models.DisplayExamQuestions;
import org.dippy.models.Exam;
import org.dippy.models.Login;
import org.dippy.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public User validateUser(Login login) {
        User user = new User();
        user.setName("abc");
        user.setBirthDate("abc");
        user.setEmailId("abc");
        user.setUserName("abc");
        user.setPassword("abc");

        user.setUserCategory("Faculty");
        return user;
    }

    public User validateEmail(String emailId) {
        User user = new User();
        user.setName("abc");
        user.setBirthDate("abc");
        user.setEmailId("abc");
        user.setUserName("abc");
        user.setPassword("abc");
        user.setUserCategory("Faculty");
        return user;
    }

    public void saveData(User user) {
        System.out.println("Hi all data saved");
    }

    /*public List<Exam> retrivequestionBank(String subject) {
        List<Exam> listOfExam = new ArrayList<>();
        List<String> answerOption = new ArrayList<>();
        answerOption.add("A");answerOption.add("B");answerOption.add("C");answerOption.add("D");
        Exam question1 = new Exam("Physics","What is your name?","A","B","C","D","A","2.5");
        listOfExam.add(question1);
        Exam question2 = new Exam("Physics","What is your surname?","A","B","C","D","B","0.5");
        listOfExam.add(question2);
        Exam question3 = new Exam("Physics","What is your fav food?","A","B","C","D","A","1.5");
        listOfExam.add(question3);
        Exam question4 = new Exam("Physics","What is your mother name?","A","B","C","D","D","3");
        listOfExam.add(question4);
        return listOfExam;
    }*/

    public String saveData(Exam exam) {
        System.out.println("all Exam data saved!!");
        return exam.getSubject();
    }

    /*public List<Exam> retrivequestionPaper(String subject) {

        List<Exam> examList = new ArrayList<>();
        List<String> answersOption = new ArrayList<>();
        answersOption.add("OptionA");answersOption.add("OptionB");answersOption.add("OptionC");answersOption.add("OptionD");
        List<String> answers1Option = new ArrayList<>();
        answers1Option.add("Option1");answers1Option.add("Option2");answers1Option.add("Option3");answers1Option.add("Option4");
        examList.add(new Exam("What is your name?","A","B","C","D"));
        examList.add(new Exam("What is your birthdate?","A","B","C","D"));
        examList.add(new Exam("What is your college name?","A","B","C","D"));
        examList.add(new Exam("What is your experience?","A","B","C","D"));

        return examList;
    }*/

    public double calculation(List<Exam> examList) {
        return 10.4;
    }
}
