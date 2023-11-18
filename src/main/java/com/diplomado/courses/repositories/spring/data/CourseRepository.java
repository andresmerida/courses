package com.diplomado.courses.repositories.spring.data;

import com.diplomado.courses.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
