
package com.example.eventos.entities;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private Long id; //id estudiante
    private String name; //nombre
    private String email; //email
    private List<Event> events = new ArrayList<>(); //eventos inscritos

    public Student() {}

    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Event> getEvents() { return events; }
    public void setEvents(List<Event> events) { this.events = events; }
}
