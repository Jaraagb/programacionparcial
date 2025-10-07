
package com.example.eventos.controller;

import com.example.eventos.entities.Student;
import com.example.eventos.entities.Event;
import com.example.eventos.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService svc;
    public StudentController(StudentService svc) { this.svc = svc; }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student s) {
        return ResponseEntity.ok(svc.create(s));
    }

    @PostMapping("/{sid}/events/{eid}")
    public ResponseEntity<Student> enroll(@PathVariable Long sid, @PathVariable Long eid) {
        return svc.enroll(sid, eid).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{sid}/events")
    public ResponseEntity<List<Event>> studentEvents(@PathVariable Long sid) {
        List<Event> ev = svc.eventsOfStudent(sid);
        if (ev == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ev);
    }
}
