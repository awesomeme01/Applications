package com.example.demo.services;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPerson();
    Person getPersonById(Long id);
    Person createPerson(Person person);
    void deletePerson(Long id);
}
