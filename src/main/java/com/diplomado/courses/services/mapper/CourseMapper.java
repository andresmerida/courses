package com.diplomado.courses.services.mapper;

import com.diplomado.courses.domain.entities.Course;
import com.diplomado.courses.dto.CourseDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper implements CustomMapper<CourseDTO, Course> {
    @Override
    public CourseDTO toDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDepartment(course.getDepartment());

        return courseDTO;
    }

    @Override
    public Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setDepartment(courseDTO.getDepartment());

        return course;
    }
}
