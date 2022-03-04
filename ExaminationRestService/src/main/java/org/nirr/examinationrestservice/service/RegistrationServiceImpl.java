package org.nirr.examinationrestservice.service;

import org.dippy.entities.LoginTblm;
import org.dippy.entities.UserTblm;
import org.dippy.models.User;
import org.nirr.examinationrestservice.dao.LoginDao;
import org.nirr.examinationrestservice.dao.RegistrationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationServiceImpl implements RegistrationService{

    RegistrationDao registrationDao;
    LoginDao loginDao;

    @Autowired
    public RegistrationServiceImpl(RegistrationDao registrationDao, LoginDao loginDao) {
        this.registrationDao = registrationDao;
        this.loginDao = loginDao;
    }

    public String createUser(User user){
        UserTblm userTblm = new UserTblm();

        userTblm.setName(user.getName());
        userTblm.setBirthDate(user.getBirthDate());
        userTblm.setUserCategory(user.getUserCategory());
        userTblm.setEmailId(user.getEmailId());

        LoginTblm loginTblm = new LoginTblm();
        loginTblm.setUserId(user.getUserName());
        loginTblm.setPassword(user.getPassword());

        userTblm.setLoginTblm(loginTblm);
        loginTblm.setUserTblm(userTblm);

        UserTblm userTblm2 = registrationDao.save(userTblm);
        loginDao.save(loginTblm);

        return userTblm2.getName();
    }
}
