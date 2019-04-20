package com.example.demo.services;

import com.example.demo.model.Application;
import com.example.demo.model.Person;
import com.example.demo.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> getAllApplication() {
        return applicationRepository.findAll();
    }

    @Override
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).get();
    }

    @Override
    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public List<Application> getApplicationsByPerson(Person person) {
        return applicationRepository.findAll().stream().filter(x-> x.getPerson().equals(person)).collect(Collectors.toList());
    }
}
