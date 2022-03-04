package org.nirr.examinationrestservice.service;

import org.dippy.entities.QuestionTblm;
import org.dippy.models.Exam;
import org.dippy.models.Question;
import org.dippy.models.Result;
import org.dippy.models.StudentPaper;

import java.util.List;

public interface StudentService {

    List<QuestionTblm> retriveQuestionPaper(String subject);

    Double calculation(Result resultObject);

    Exam createExam(Exam exam);
}
