package com.example.demo.services;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
