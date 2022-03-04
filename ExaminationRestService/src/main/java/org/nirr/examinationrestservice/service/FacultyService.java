package org.nirr.examinationrestservice.service;

import org.dippy.models.Exam;
import org.dippy.models.Question;

import java.util.List;

public interface FacultyService {

    void saveQuestion(Question exam);

    List<Question> retriveQuestionBank(Exam examSubject);

    List<Exam> retrieveStudentDataOfExam();
}
