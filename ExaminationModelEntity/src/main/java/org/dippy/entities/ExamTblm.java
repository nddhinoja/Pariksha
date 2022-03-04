package org.dippy.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TBLM_EXAM")
public class ExamTblm {

    private Long examId;
    private String examDate;
    private String examSubject;
    private Double result;
    private UserTblm userTblm;
    private Set<QuestionTblm> questionTblms = new HashSet<QuestionTblm>();

    public ExamTblm() {
    }

    public ExamTblm(Long examId, String examDate, String examSubject, Double result, UserTblm userTblm) {
        this.examId = examId;
        this.examDate = examDate;
        this.examSubject = examSubject;
        this.result = result;
        this.userTblm = userTblm;
    }

    public ExamTblm(String examDate, String examSubject, UserTblm userTblm, Set<QuestionTblm> questionTblms) {
        this.examDate = examDate;
        this.examSubject = examSubject;
        this.userTblm = userTblm;
        this.questionTblms = questionTblms;
    }

    public ExamTblm(String examDate, String examSubject, UserTblm userTblm) {
        this.examDate = examDate;
        this.examSubject = examSubject;
        this.userTblm = userTblm;
    }

    public ExamTblm(String examDate, String examSubject) {
        this.examDate = examDate;
        this.examSubject = examSubject;
    }

    public ExamTblm(Long examId, String examDate, String examSubject) {
        this.examId = examId;
        this.examDate = examDate;
        this.examSubject = examSubject;
    }

    @Id
    @Column(name = "EXAM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    @Column(name = "EXAMDATE")
    public String getExamDate() {
        return examDate;
    }
    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    @Column(name = "EXAMSUBJECT")
    public String getExamSubject() {
        return examSubject;
    }
    public void setExamSubject(String examSubject) {
        this.examSubject = examSubject;
    }

    @Column(name = "RESULT")
    public Double getResult() {return result;}
    public void setResult(Double result) {this.result = result;}

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public UserTblm getUserTblm() {return userTblm;}
    public void setUserTblm(UserTblm userTblm) {
        this.userTblm = userTblm;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "EXAM_QUESTION",
            joinColumns = {@JoinColumn(name = "EXAM_ID")},
            inverseJoinColumns = {@JoinColumn(name = "QUESTION_ID")})
    public Set<QuestionTblm> getQuestionTblms() {
        return questionTblms;
    }

    public void setQuestionTblms(Set<QuestionTblm> questionTblms) {
        this.questionTblms = questionTblms;
    }
}
