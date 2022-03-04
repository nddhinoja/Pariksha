package org.nirr.examinationrestservice.dao;

import org.dippy.entities.LoginTblm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginDao extends JpaRepository<LoginTblm,Long> {

    @Query(value = "SELECT l.userId from LoginTblm l where l.userId=?1 and l.password=?2")
    String existsLoginTblmByUserIdAndPassword(String userId, String password);

}
