package org.nirr.examinationrestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("org.dippy.entities")
public class ExaminationRestServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExaminationRestServiceApplication.class, args);
    }
<<<<<<< HEAD
=======

>>>>>>> parent of d07563f (Bank view Question-not working)
}
