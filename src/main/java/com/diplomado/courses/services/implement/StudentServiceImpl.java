package com.diplomado.courses.services.implement;

import com.diplomado.courses.domain.entities.Student;
import com.diplomado.courses.domain.entities.StudentIdCard;
import com.diplomado.courses.dto.StudentDTO;
import com.diplomado.courses.repositories.spring.data.StudentIdCardRepository;
import com.diplomado.courses.repositories.spring.data.StudentRepository;
import com.diplomado.courses.services.StudentService;
import com.diplomado.courses.services.mapper.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    private final StudentIdCardRepository studentIdCardRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper, StudentIdCardRepository studentIdCardRepository) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.studentIdCardRepository = studentIdCardRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> listStudents() {
        return studentRepository.findAllByActiveOrderByFirstNameAscLastNameAsc(Boolean.TRUE)
                .stream()
                .map(studentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> listStudentsDetailed() {
        return studentRepository.findAllByActiveOrderByFirstNameAscLastNameAsc(Boolean.TRUE)
                .stream()
                .map(studentMapper::toDtoDetailed).collect(Collectors.toList());
    }

    @Override
    public StudentDTO save(StudentDTO dto) {
        Student student = studentRepository.save(studentMapper.toEntity(dto));
        if (dto.getId() != null) { // edit
            StudentIdCard studentIdCard = new StudentIdCard();
            studentIdCard.setId(dto.getCardNumberId());
            studentIdCard.setCardNumber(dto.getCardNumber());
            studentIdCard.setStudent(student);
            studentIdCardRepository.save(studentIdCard);
        } else { // create
            studentIdCardRepository.save(new StudentIdCard(dto.getCardNumber(), student));
        }
        return studentMapper.toDto(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StudentDTO> getStudentById(Integer id) {
        return studentRepository.findById(id).map(studentMapper::toDtoDetailed);
    }

    @Override
    public void delete(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with id: " + id + " is not existed."));
        student.setActive(Boolean.FALSE);
        studentRepository.save(student);
    }
}
