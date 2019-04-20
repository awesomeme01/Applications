package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.model.Response;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(PersonController.url)

public class PersonController {
    public static final String url = "/api/person";
    @Autowired
    private PersonService personService;
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response getPersonList(){

        return new Response(true,"All people ever created",personService.getAllPerson());
    }
    @GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response getPersonById(@PathVariable Long id){
        Person person;
        try{
            person = personService.getPersonById(id);
        }
        catch (NoSuchElementException ex){
            System.out.println(ex.getMessage());
            return new Response(false, "There's no such person with id = " + id,null);
        }
        return new Response(true,"Person with id = " + id,person);
    }
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response createPerson(@RequestBody Person person){
        if(person.getAge()<0 || person.getAge() == null){
            return new Response(false,"New person creation failed!! THe age has to be non-negative number", null);
        }
        if(person.getFullname() == null){
            return new Response(false, "New person creation failed!! The name field is mandatory(cannot be null)", null);
        }
        return new Response(true,"New Person created successfully!!!!",personService.createPerson(person));
    }
    @DeleteMapping(path = "/{id}")
    public Response deletePerson(@PathVariable Long id){
        try{
            personService.deletePerson(id);
        }
        catch (EmptyResultDataAccessException ex){
            System.out.println(ex.getMessage());
            return new Response(false,"Couldn't delete person. There's no person with id  = " + id, null);
        }
        return new Response(true,"Person with id =" + id +"  deleted ",null);
    }
}
