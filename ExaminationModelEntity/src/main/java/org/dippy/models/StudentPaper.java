package org.dippy.models;

public class StudentPaper implements Comparable<StudentPaper>{

    Long questionId;
    Long selectedAnswer;

    public Long getQuestionId() {return questionId;}
    public void setQuestionId(Long questionId) {this.questionId = questionId;}

    public Long getSelectedAnswer() {return selectedAnswer;}
    public void setSelectedAnswer(Long selectedAnswer) {this.selectedAnswer = selectedAnswer;}

    @Override
    public int compareTo(StudentPaper o) {
        return this.questionId.compareTo(o.questionId);
    }
}
