package org.nirr.examinationrestservice.dao;

import org.dippy.entities.OptionTblm;
import org.dippy.entities.QuestionTblm;
import org.dippy.models.Exam;
import org.dippy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacultyDao extends JpaRepository<QuestionTblm, Long>{


    //@Query(value = "select q from QuestionTblm q where q.questionSub=?1")
    List<QuestionTblm> findAllByQuestionSub(String subject);
}
