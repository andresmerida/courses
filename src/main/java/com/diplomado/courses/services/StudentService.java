package com.diplomado.courses.services;

import com.diplomado.courses.domain.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> listStudents();
    Student save(Student student);
}
