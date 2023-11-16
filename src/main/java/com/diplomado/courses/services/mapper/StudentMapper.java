package com.diplomado.courses.services.mapper;

import com.diplomado.courses.domain.entities.Student;
import com.diplomado.courses.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements CustomMapper<StudentDTO, Student> {
    @Override
    public StudentDTO toDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());

        return dto;
    }

    public StudentDTO toDtoDetailed(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());

        dto.setCardNumber(student.getStudentIdCard().getCardNumber());

        return dto;
    }

    @Override
    public Student toEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());

        return student;
    }
}
