package com.diplomado.courses.web.rest;

import com.diplomado.courses.dto.CourseDTO;
import com.diplomado.courses.dto.CourseStudentDTO;
import com.diplomado.courses.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> listAllCourses() {
        return ResponseEntity.ok().body(courseService.listCourses());
    }

    @GetMapping("/{courseId}/students")
    public ResponseEntity<List<CourseStudentDTO>> listStudentsByCourseId(@PathVariable final Integer courseId) {
        return ResponseEntity.ok().body(courseService.listStudentsByCourseId(courseId));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@RequestBody final CourseDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new course cannot already have an id.");
        }

        CourseDTO courseDTO = this.courseService.save(dto);

        return ResponseEntity
                .created(new URI("/v1/courses/" + courseDTO.getId()))
                .body(courseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> editCourse(@RequestBody final CourseDTO dto,
                                                @PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid course id, null value");
        }
        if (!Objects.equals(dto.getId(), id)) {
            throw new IllegalArgumentException("Invalid id");
        }

        return ResponseEntity
                .ok()
                .body(this.courseService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        courseService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
