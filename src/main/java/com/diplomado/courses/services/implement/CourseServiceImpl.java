package com.diplomado.courses.services.implement;

import com.diplomado.courses.dto.CourseDTO;
import com.diplomado.courses.repositories.CourseRepository;
import com.diplomado.courses.services.CourseService;
import com.diplomado.courses.services.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

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
}
