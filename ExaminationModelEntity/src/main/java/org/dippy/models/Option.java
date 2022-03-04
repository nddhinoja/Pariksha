package org.dippy.models;

public class Option {

    Long optionId;
    String optionContent;
    boolean flag = false;
    Question question;

    public Option() {
    }

    public Option(Long optionId, String optionContent, Question question) {
        this.optionId = optionId;
        this.optionContent = optionContent;
        this.question = question;
    }

    public Option(Long optionId, String optionContent) {
        this.optionId = optionId;
        this.optionContent = optionContent;
    }

    public Option(String optionContent, boolean flag) {
        this.optionContent = optionContent;
        this.flag = flag;
    }

    public Option(Long optionId, String optionContent, boolean flag) {
        this.optionId = optionId;
        this.optionContent = optionContent;
        this.flag = flag;
    }

    public Option(String optionContent) {
        this.optionContent = optionContent;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    public boolean isFlag() {return flag;}
    public void setFlag(boolean flag) {this.flag = flag;}

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
