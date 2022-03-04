package org.nirr.examinationrestservice.service;

import org.dippy.models.Email;
import org.dippy.models.Login;
import org.dippy.models.User;

public interface LoginService {

    public User validateUser(Login login);
    public User validateEmail(String emailId);
}
