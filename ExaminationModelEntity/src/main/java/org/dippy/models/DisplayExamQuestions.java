package org.dippy.models;

import java.util.List;

public class DisplayExamQuestions {

    private List<Exam> examList;

    public DisplayExamQuestions(List<Exam> examList) {
        this.examList = examList;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }
}
