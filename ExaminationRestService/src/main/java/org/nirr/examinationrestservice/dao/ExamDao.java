package org.nirr.examinationrestservice.dao;

import org.dippy.entities.ExamTblm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ExamDao extends JpaRepository<ExamTblm,Long> {

    @Transactional
    @Modifying
    @Query("update ExamTblm e set e.result = ?1 where e.examId = ?2")
    void saveResult(Double result,Long examId);
}
