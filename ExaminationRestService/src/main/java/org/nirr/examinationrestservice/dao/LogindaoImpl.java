package org.nirr.examinationrestservice.dao;

import org.dippy.models.Login;
import org.dippy.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class LogindaoImpl {

    public User validateUser(Login login){
        User user = new User();
        user.setName("abc");
        user.setBirthDate("abc");
        user.setEmailId("abc");
        user.setUserName("abc");
        user.setPassword("abc");
        user.setUserCategory("Student");
        return user;
    }

    public User validateEmail(String emailId) {
        User user = new User();
        user.setName("abc");
        user.setBirthDate("abc");
        user.setEmailId("abc");
        user.setUserName("abc");
        user.setPassword("abc");
        user.setUserCategory("Faculty");
        return user;
    }
}
