package com.example.demo.services;

import com.example.demo.model.Application;
import com.example.demo.model.Person;

import java.util.List;

public interface ApplicationService {
    List<Application> getAllApplication();
    Application getApplicationById(Long id);
    Application createApplication(Application application);
    void deleteApplication(Long id);
    List<Application> getApplicationsByPerson(Person person);
}
