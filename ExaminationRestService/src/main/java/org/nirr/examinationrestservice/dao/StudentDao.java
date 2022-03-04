package org.nirr.examinationrestservice.dao;

import org.dippy.entities.QuestionTblm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDao extends JpaRepository<QuestionTblm,Long> {

    @Query("select q from QuestionTblm q where q.questionSub=?1")
    List<QuestionTblm> retriveQuestionPaper(String subject);

    //Double calculation(List<Exam> examList);
}
