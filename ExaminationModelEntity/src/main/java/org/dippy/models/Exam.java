package org.dippy.models;

import java.util.List;

public class Exam {

     Long examId;
     String Subject;
     String examDate;
     Double marks;
     List<Question> questionList;
     User user;

    public Exam() {
    }

    public Exam(Long examId,String subject, String examDate, List<Question> questionList, User user) {
        this.examId = examId;
        Subject = subject;
        this.examDate = examDate;
        this.questionList = questionList;
        this.user = user;
    }

    public Exam(Long examId, String subject, String examDate, Double marks, User user) {
        this.examId = examId;
        Subject = subject;
        this.examDate = examDate;
        this.marks = marks;
        this.user = user;
    }

    public Exam(String subject, String examDate, Double marks) {
        Subject = subject;
        this.examDate = examDate;
        this.marks = marks;
    }

    public Exam(String subject, String examDate, User user) {
        Subject = subject;
        this.examDate = examDate;
        this.user = user;
    }

    public Long getExamId() {
        return examId;
    }
    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getSubject() {
        return Subject;
    }
    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getExamDate() {
        return examDate;
    }
    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public Double getMarks() {
        return marks;
    }
    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public List<Question> getQuestionList() {return questionList;}
    public void setQuestionList(List<Question> questionList) {this.questionList = questionList;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

}
