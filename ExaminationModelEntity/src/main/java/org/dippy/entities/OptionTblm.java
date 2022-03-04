package org.dippy.entities;


import javax.persistence.*;

@Entity
@Table(name = "TBLM_OPTION")
public class OptionTblm {

    Long optionId;
    String optionContent;
    boolean flag = false;
    QuestionTblm questionTblm;

    public OptionTblm() {
    }

    public OptionTblm(String optionContent) {
        this.optionContent = optionContent;
    }

    public OptionTblm(String optionContent, boolean flag) {
        this.optionContent = optionContent;
        this.flag = flag;
    }

    public OptionTblm(Long optionId, String optionContent, boolean flag) {
        this.optionId = optionId;
        this.optionContent = optionContent;
        this.flag = flag;
    }

    @Id
    @Column(name = "OPTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getOptionId() {
        return optionId;
    }
    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    @Column(name = "OPTION_CONTENT")
    public String getOptionContent() {return optionContent;}
    public void setOptionContent(String optionContent) {this.optionContent = optionContent;}

    @Column(name = "FLAG")
    public boolean isFlag() {return flag;}
    public void setFlag(boolean flag) {this.flag = flag;}

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    public QuestionTblm getQuestionTblm() {
        return questionTblm;
    }
    public void setQuestionTblm(QuestionTblm questionTblm) {
        this.questionTblm = questionTblm;
    }
}
