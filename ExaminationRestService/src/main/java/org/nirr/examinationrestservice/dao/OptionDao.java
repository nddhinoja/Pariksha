package org.nirr.examinationrestservice.dao;

import org.dippy.entities.OptionTblm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionDao extends JpaRepository<OptionTblm, Long> {

}
