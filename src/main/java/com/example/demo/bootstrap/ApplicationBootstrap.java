package com.example.demo.bootstrap;

import com.example.demo.model.Application;
import com.example.demo.model.Person;
import com.example.demo.services.ApplicationService;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ApplicationBootstrap implements CommandLineRunner {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private PersonService personService;

    @Override
    public void run(String... args) throws Exception {
//        Person p1 = new Person("Shabdan",17);
//        Application ap1 = new Application(p1, LocalDateTime.now(),"Hey new Application");
//        Application ap2 = new Application(p1, LocalDateTime.now(),"Hey second new Application");
//        Application ap3 = new Application(p1, LocalDateTime.now(),"Hey third new Application");
//        Application ap4 = new Application(p1, LocalDateTime.now(),"Hey fourth new Application");
//        personService.createPerson(p1);
//
//        applicationService.createApplication(ap1);
//        applicationService.createApplication(ap2);
//        applicationService.createApplication(ap3);
//        applicationService.createApplication(ap4);
    }
}
