package com.diplomado.courses.repositories.spring.jdbc.implement;

import com.diplomado.courses.dto.CountryDTO;
import com.diplomado.courses.repositories.spring.jdbc.CountryJdbcRepository;
import com.diplomado.courses.repositories.spring.jdbc.implement.row.mapper.CountryRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CountryJdbcRepositoryImpl implements CountryJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    public CountryJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CountryDTO> listCountries() {
        var sql = """
                SELECT id, name, initials
                FROM country
                """;
        return jdbcTemplate.query(sql, new CountryRowMapper());
    }

    @Override
    public Optional<CountryDTO> getCountryById(Integer countryId) {
        var sql = """
                SELECT id, name, initials
                FROM country
                WHERE id=?
                """;
        return jdbcTemplate.query(sql, new CountryRowMapper(), countryId)
                .stream()
                .findFirst();
    }

    @Override
    public int save(CountryDTO countryDTO) {
        var sql = """
                INSERT INTO country (id, name, initials) VALUES (nextval('my_sequence'), ?, ?)
                """;
        return jdbcTemplate.update(sql, countryDTO.getName(), countryDTO.getInitials());
    }

    @Override
    public int delete(Integer countryId) {
        var sql = """
                DELETE FROM country WHERE id=?
                """;
        return jdbcTemplate.update(sql, countryId);
    }
}
