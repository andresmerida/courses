package com.diplomado.courses.repositories.spring.data;

import com.diplomado.courses.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
