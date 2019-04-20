package com.example.demo.controller;

import com.example.demo.model.Application;
import com.example.demo.model.Person;
import com.example.demo.model.Response;
import com.example.demo.services.ApplicationService;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(ApplicationController.url)

public class ApplicationController {
    public static final String url = "/api/applications";
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private PersonService personService;
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})

    public Response getApplications(){
        return new Response(true, "All applications ever created!!!",applicationService.getAllApplication());
    }
    @GetMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response getApplicationById(@PathVariable Long id){
        Application application;
        try{
            application = applicationService.getApplicationById(id);
        }
        catch (NoSuchElementException ex){
            System.out.println(ex.getMessage());
            return new Response(false,"Application with id = " + id + " doesn't exist!!!!",null);
        }
        return new Response(true,"Application by id = " + id, application);
    }
    @GetMapping(path = "/byPerson/{id}")
    public Response getApplicationByPerson(@PathVariable Long id){
        List<Application> applicationList;
        try{
            applicationList = applicationService.getApplicationsByPerson(personService.getPersonById(id));
        }
        catch (NoSuchElementException ex){
            System.out.println(ex.getMessage());
            return new Response(false,"Finding application by person failed. Person with id = " + id + " doesn't exist!!!!",null);
        }
        return new Response(true,"Application by person with id = " + id,applicationList);
    }
    @PostMapping(path = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Response createApplication(@RequestBody Application application,@PathVariable Long id){
        application.setPerson(personService.getPersonById(id));
        if(application.getPerson().getAge()<16){
            return new Response(false,"Application creation failed! Age has to be 16 or higher(", null);
        }
        if(application.getPerson() == null){
            return new Response(false, "The identity of a person is mandatory", null);
        }
        return new Response(true,git"Application created!!!",applicationService.createApplication(application));
    }
    @DeleteMapping(path = "/{id}")
    public Response deleteApplication(@PathVariable Long id){
        try{
            applicationService.deleteApplication(id);
        }
        catch (EmptyResultDataAccessException ex){
            System.out.println(ex.getMessage());
            return new Response(false,"Couldn't delete application. Application with id = " + id + " doesn't exist!!!",null);
        }
        return new Response(true, "Application with id = " + id + " has been deleted!!!",null);
    }
}
