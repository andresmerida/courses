package com.diplomado.courses.repositories.spring.jdbc;

import com.diplomado.courses.dto.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryJdbcRepository {
    List<CountryDTO> listCountries();
    Optional<CountryDTO> getCountryById(Integer countryId);
    int save(CountryDTO countryDTO);
    int delete(Integer countryId);
}
