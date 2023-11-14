package com.diplomado.courses.repositories;

import com.diplomado.courses.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
