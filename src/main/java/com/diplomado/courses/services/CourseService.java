package com.diplomado.courses.services;

import com.diplomado.courses.domain.entities.Student;
import com.diplomado.courses.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<CourseDTO> listCourses();
    CourseDTO save(CourseDTO dto);
    Optional<CourseDTO> getCourseById(Integer courseId);
    void delete(Integer courseId);
}
