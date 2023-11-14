package com.diplomado.courses.services;

import com.diplomado.courses.domain.entities.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> getEnrollmentsByStudentId(Integer studentId);
    Enrollment save(Enrollment enrollment);
}
