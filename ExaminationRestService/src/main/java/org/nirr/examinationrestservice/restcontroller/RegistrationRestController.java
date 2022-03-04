package org.nirr.examinationrestservice.restcontroller;

import org.dippy.models.User;
import org.nirr.examinationrestservice.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RegistrationRestController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping(value = "/successfullregistration", produces = "text/plain",
            consumes = "application/json")
    public String afterRegistration(@RequestBody User user){
        String name = registrationService.createUser(user);
        System.out.println(name+"Rest Controller");
        return name;
    }
}
