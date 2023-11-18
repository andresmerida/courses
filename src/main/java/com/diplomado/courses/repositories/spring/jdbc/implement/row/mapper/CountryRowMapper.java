package com.diplomado.courses.repositories.spring.jdbc.implement.row.mapper;

import com.diplomado.courses.dto.CountryDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<CountryDTO> {
    @Override
    public CountryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CountryDTO(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("initials")
        );
    }
}
