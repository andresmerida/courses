package com.diplomado.courses.services.implement;

import com.diplomado.courses.dto.CourseDTO;
import com.diplomado.courses.dto.CourseStudentDTO;
import com.diplomado.courses.repositories.spring.data.CourseRepository;
import com.diplomado.courses.repositories.spring.jdbc.CourseJdbcRepository;
import com.diplomado.courses.services.CourseService;
import com.diplomado.courses.services.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    private CourseJdbcRepository courseJdbcRepository;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }


    @Override
    public List<CourseDTO> listCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CourseStudentDTO> listStudentsByCourseId(Integer courseId) {
        return courseJdbcRepository.listStudentsByCourseId(courseId);
    }

    @Override
    public CourseDTO save(CourseDTO dto) {
        return this.courseMapper
                .toDto(courseRepository.save(this.courseMapper.toEntity(dto)));
    }

    @Override
    public Optional<CourseDTO> getCourseById(Integer courseId) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer courseId) {
        courseRepository.deleteById(courseId);
    }

    @Autowired
    public void setCourseJdbcRepository(CourseJdbcRepository courseJdbcRepository) {
        this.courseJdbcRepository = courseJdbcRepository;
    }
}
