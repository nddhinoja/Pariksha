package org.nirr.examinationrestservice.restcontroller;

import org.dippy.models.Email;
import org.dippy.models.Login;
import org.dippy.models.User;
import org.nirr.examinationrestservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class LoginRestController {

    @Autowired
    LoginService loginService;

    @PostMapping(path="/loginvalidate")
    public User validatingUser(@RequestBody Login login){
        User validateUser = loginService.validateUser(login);
        return validateUser;
    }

    @PostMapping(value = "/emailvalidate", produces= "application/json", consumes = "application/json")
    public User verifyingEmail(@RequestBody Email emailId){
        System.out.println(emailId.getEmailId());
        User user = loginService.validateEmail(emailId.getEmailId());
        System.out.println(user.getName());//extra
        return user;
    }

}
