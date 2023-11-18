package com.diplomado.courses.repositories.spring.jdbc.implement.row.mapper;

import com.diplomado.courses.dto.CourseStudentDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseStudentRowMapper implements RowMapper<CourseStudentDTO> {
    @Override
    public CourseStudentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CourseStudentDTO(
                new StringBuilder()
                        .append(rs.getString("first_name"))
                        .append(" ")
                        .append(rs.getString("last_name")).toString(),
                rs.getString("email"),
                rs.getInt("age"),
                rs.getString("card_number"),
                rs.getInt("grade")
        );
    }
}
