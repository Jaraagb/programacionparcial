
package com.example.eventos.entities;

import java.time.LocalDate;

public class Event {
    private Long id; //id evento
    private String name; //nombre
    private LocalDate date; //fecha
    private int durationHours; //duracion hrs
    private Modality modality; //modalidad

    public enum Modality { PRESENCIAL, VIRTUAL }

    public Event() {}

    public Event(Long id, String name, LocalDate date, int durationHours, Modality modality) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.durationHours = durationHours;
        this.modality = modality;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public int getDurationHours() { return durationHours; }
    public void setDurationHours(int durationHours) { this.durationHours = durationHours; }

    public Modality getModality() { return modality; }
    public void setModality(Modality modality) { this.modality = modality; }
}
