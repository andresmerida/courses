package com.diplomado.courses.services;

import com.diplomado.courses.dto.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<CountryDTO> listCountries();
    Optional<CountryDTO> getCountryById(Integer countryId);
    int save(CountryDTO countryDTO);
    int delete(Integer countryId);

}
