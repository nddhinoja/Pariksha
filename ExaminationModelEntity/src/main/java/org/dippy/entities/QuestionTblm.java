package org.dippy.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBLM_QUESTION")
public class QuestionTblm {

    private Long questionId;
    private String questionSub;
    private String question;
    private Double weightage;

    private Set<OptionTblm> listOfoptionTblm = new HashSet<>(4);
    private Set<ExamTblm> examTblms = new HashSet<ExamTblm>();

    public QuestionTblm() {
    }

    public QuestionTblm(String questionSub, String question, Double weightage, Set<OptionTblm> optionTblms) {
        this.questionSub = questionSub;
        this.question = question;
        this.weightage = weightage;
        this.listOfoptionTblm = optionTblms;
    }

    @Id
    @Column(name = "QUESTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getQuestionId() {
        return questionId;
    }
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Column(name = "QUESTIon_SUB")
    public String getQuestionSub() {
        return questionSub;
    }
    public void setQuestionSub(String questionSub) {
        this.questionSub = questionSub;
    }

    @Column(name = "QUESTION")
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    @Column(name = "WEIGHTAGE")
    public Double getWeightage() {
        return weightage;
    }
    public void setWeightage(Double weightage) {
        this.weightage = weightage;
    }

    @OneToMany(mappedBy = "questionTblm", cascade = {CascadeType.PERSIST})
    public Set<OptionTblm> getListOfoptionTblm() {return listOfoptionTblm;}
    public void setListOfoptionTblm(Set<OptionTblm> listOfoptionTblm) {this.listOfoptionTblm = listOfoptionTblm;}

    @ManyToMany(mappedBy = "questionTblms")
    public Set<ExamTblm> getExamTblms() {
        return examTblms;
    }
    public void setExamTblms(Set<ExamTblm> examTblms) {
        this.examTblms = examTblms;
    }
}
