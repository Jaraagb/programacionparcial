
package com.example.eventos.service;

import com.example.eventos.entities.Student;
import com.example.eventos.entities.Event;
import com.example.eventos.repository.StudentRepository;
import com.example.eventos.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository sRepo;
    private final EventRepository eRepo;

    public StudentService(StudentRepository sRepo, EventRepository eRepo) {
        this.sRepo = sRepo;
        this.eRepo = eRepo;
    }

    public Student create(Student s) { return sRepo.save(s); } //crear estudiante

    public Optional<Student> findById(Long id) { return sRepo.findById(id); } //buscar

    public Optional<Student> enroll(Long studentId, Long eventId) {
        Optional<Student> os = sRepo.findById(studentId);
        Optional<Event> oe = eRepo.findById(eventId);
        if (!os.isPresent() || !oe.isPresent()) return Optional.empty();
        Student st = os.get();
        st.getEvents().add(oe.get()); //inscribir
        return Optional.of(st);
    }

    public List<Event> eventsOfStudent(Long studentId) {
        Optional<Student> os = sRepo.findById(studentId);
        return os.map(Student::getEvents).orElse(null);
    }
}
