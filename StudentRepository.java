
package com.example.eventos.repository;

import com.example.eventos.entities.Student;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private final List<Student> students = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong seq = new AtomicLong(1);

    public Student save(Student s) {
        if (s.getId() == null) s.setId(seq.getAndIncrement()); //gen id
        students.add(s);
        return s;
    }

    public Optional<Student> findById(Long id) {
        for (Student s : students) if (s.getId().equals(id)) return Optional.of(s);
        return Optional.empty();
    }

    public List<Student> findAll() { return new ArrayList<>(students); }
}
