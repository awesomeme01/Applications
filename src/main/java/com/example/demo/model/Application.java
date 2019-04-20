package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Person person;
    private LocalDateTime time;
    private String message;

    public Application (){

    }
    public Application(Person person, LocalDateTime time, String message) {
        this.id = id;
        this.person = person;
        this.time = time;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
