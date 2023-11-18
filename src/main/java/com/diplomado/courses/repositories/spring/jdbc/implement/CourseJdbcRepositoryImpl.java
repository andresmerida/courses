package com.diplomado.courses.repositories.spring.jdbc.implement;

import com.diplomado.courses.dto.CourseStudentDTO;
import com.diplomado.courses.repositories.spring.jdbc.CourseJdbcRepository;
import com.diplomado.courses.repositories.spring.jdbc.implement.row.mapper.CourseStudentRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseJdbcRepositoryImpl implements CourseJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public CourseJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CourseStudentDTO> listStudentsByCourseId(Integer courseId) {
        var sql = """
                SELECT s.first_name, s.last_name, s.email, s.age, sic.card_number, e.grade
                FROM student s
                INNER JOIN enrollment e on s.id = e.student_id
                INNER JOIN student_id_card sic on s.id = sic.student_id
                WHERE e.course_id=?
                ORDER BY s.first_name, s.last_name;
                """;
        return jdbcTemplate.query(sql, new CourseStudentRowMapper(), courseId);
    }
}
