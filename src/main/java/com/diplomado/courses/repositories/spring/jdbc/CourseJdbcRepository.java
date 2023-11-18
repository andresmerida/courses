package com.diplomado.courses.repositories.spring.jdbc;

import com.diplomado.courses.dto.CourseStudentDTO;

import java.util.List;

public interface CourseJdbcRepository {
    List<CourseStudentDTO> listStudentsByCourseId(Integer courseId);
}
