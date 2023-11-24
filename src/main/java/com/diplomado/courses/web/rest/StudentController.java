package com.diplomado.courses.web.rest;

import com.diplomado.courses.dto.StudentDTO;
import com.diplomado.courses.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> listStudents(@RequestParam(required = false, defaultValue = "false") boolean detailed) {
        if (detailed) {
            return ResponseEntity.ok().body(studentService.listStudentsDetailed());
        } else {
            return ResponseEntity.ok().body(studentService.listStudents());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(studentService.getStudentById(id).orElseThrow(() -> new IllegalArgumentException("Resource not found exception for the id: " + id)));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@RequestBody final StudentDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new student cannot already have an id.");
        }

        StudentDTO studentDB = studentService.save(dto);

        return ResponseEntity.created(new URI("/v1/students/" + studentDB.getId())).body(studentDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> editStudent(@RequestBody final StudentDTO dto,
                                                @PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid student id, null value");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }

        return ResponseEntity
                .ok()
                .body(this.studentService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> logicalDelete(@PathVariable final Integer id) {
        studentService.delete(id);

        return ResponseEntity.ok().build();
    }
}
