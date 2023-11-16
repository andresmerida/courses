package com.diplomado.courses.services;

import com.diplomado.courses.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDTO> listStudents();
    List<StudentDTO> listStudentsDetailed();
    StudentDTO save(StudentDTO dto);
    Optional<StudentDTO> getStudentById(Integer id);
    void delete(Integer id);
}
