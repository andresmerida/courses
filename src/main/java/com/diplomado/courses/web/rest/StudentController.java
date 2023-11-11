package com.diplomado.courses.web.rest;

import com.diplomado.courses.domain.entities.Student;
import com.diplomado.courses.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> listStudents() {
        return ResponseEntity.ok().body(studentService.listStudents());
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody final Student student) throws URISyntaxException {
        if (student.getId() != null) {
            throw new IllegalArgumentException("I new student cannot already have an id.");
        }

        Student studentDB = studentService.save(student);

        return ResponseEntity.created(new URI("/v1/students/" + studentDB.getId())).body(studentDB);
    }
}
