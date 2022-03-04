package org.dippy.models;

import java.util.List;

public class Question {

    private Long questionId;
    private String questionContent;
    private List<Option> optionList;
    private Double weightage;
    private String questionSub;

    public Question() {
    }

    public Question(String questionContent, List<Option> optionList) {
        this.questionContent = questionContent;
        this.optionList = optionList;
    }

    public Question(Long questionId, String questionContent, List<Option> optionList) {
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.optionList = optionList;
    }

    public Question(Long questionId, String questionContent, List<Option> optionList, Double weightage, String questionSub) {
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.optionList = optionList;
        this.weightage = weightage;
        this.questionSub = questionSub;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    public String getQuestionSub() {return questionSub;}

    public void setQuestionSub(String questionSub) {this.questionSub = questionSub;}

    public Double getWeightage() {return weightage;}
    public void setWeightage(Double weightage) {this.weightage = weightage;}
}
