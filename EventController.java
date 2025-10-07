
package com.example.eventos.controller;

import com.example.eventos.entities.Event;
import com.example.eventos.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService svc;
    public EventController(EventService svc) { this.svc = svc; }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event e) {
        return ResponseEntity.ok(svc.create(e));
    }

    @GetMapping
    public ResponseEntity<List<Event>> all() {
        return ResponseEntity.ok(svc.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable Long id) {
        return svc.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
