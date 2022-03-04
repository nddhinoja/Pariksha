package org.dippy.models;

import java.util.List;

public class User {

    private String userCategory;
    private String name;
    private String birthDate;
    private String emailId;
    private String userName;
    private String password;
    private List<Exam> examList;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String userCategory, String name, String birthDate, String emailId, String userName, List<Exam> exam) {
        this.userCategory = userCategory;
        this.name = name;
        this.birthDate = birthDate;
        this.emailId = emailId;
        this.userName = userName;
        this.examList = exam;
    }

    public User(String userCategory, String name, String birthDate, String emailId, String userName) {
        this.userCategory = userCategory;
        this.name = name;
        this.birthDate = birthDate;
        this.emailId = emailId;
        this.userName = userName;
    }

    public User(String userCategory, String name, String birthDate, String emailId) {
        this.userCategory = userCategory;
        this.name = name;
        this.birthDate = birthDate;
        this.emailId = emailId;
    }

    public User(String name, List<Exam> exam) {
        this.name = name;
        this.examList = exam;
    }

    public List<Exam> getExam() {
        return examList;
    }

    public void setExam(List<Exam> exam) {
        this.examList = exam;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
