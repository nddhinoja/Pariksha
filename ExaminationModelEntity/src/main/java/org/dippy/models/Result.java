package org.dippy.models;

import java.util.List;

public class Result {

    Long examId;
    List<StudentPaper> list;

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public List<StudentPaper> getList() {
        return list;
    }

    public void setList(List<StudentPaper> list) {
        this.list = list;
    }
}
