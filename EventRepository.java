
package com.example.eventos.repository;

import com.example.eventos.entities.Event;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepository {
    private final List<Event> events = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong seq = new AtomicLong(1);

    public Event save(Event e) {
        if (e.getId() == null) e.setId(seq.getAndIncrement()); //gen id
        events.add(e);
        return e;
    }

    public Optional<Event> findById(Long id) {
        for (Event e : events) if (e.getId().equals(id)) return Optional.of(e);
        return Optional.empty();
    }

    public List<Event> findAll() { return new ArrayList<>(events); }
}
