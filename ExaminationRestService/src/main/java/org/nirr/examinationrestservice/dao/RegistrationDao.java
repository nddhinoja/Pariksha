package org.nirr.examinationrestservice.dao;

import org.dippy.entities.ExamTblm;
import org.dippy.entities.UserTblm;
import org.dippy.models.Email;
import org.dippy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RegistrationDao extends JpaRepository<UserTblm, Long> {

    @Query(value = "SELECT u from UserTblm u where u.userId=?1")
    UserTblm getById(String userId);

    @Query(value = "SELECT u from UserTblm u where u.emailId=?1")
    UserTblm validateEmail(String emailId);

    @Query(value = "select u.examTblmList from UserTblm u where u.userId=?1")
    Set<ExamTblm> findExamTblmSet(String userName);
}
