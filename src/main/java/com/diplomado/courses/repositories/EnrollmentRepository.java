package com.diplomado.courses.repositories;

import com.diplomado.courses.domain.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findAllByStudent_IdOrderById(Integer studentId);
}
