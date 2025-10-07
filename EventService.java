
package com.example.eventos.service;

import com.example.eventos.entities.Event;
import com.example.eventos.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository repo;
    public EventService(EventRepository repo) { this.repo = repo; }

    public Event create(Event e) { return repo.save(e); } //crear evento

    public List<Event> all() { return repo.findAll(); } //todos

    public Optional<Event> findById(Long id) { return repo.findById(id); } //buscar
}
