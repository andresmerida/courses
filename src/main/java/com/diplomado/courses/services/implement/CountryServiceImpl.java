package com.diplomado.courses.services.implement;

import com.diplomado.courses.dto.CountryDTO;
import com.diplomado.courses.repositories.spring.jdbc.CountryJdbcRepository;
import com.diplomado.courses.services.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryJdbcRepository countryJdbcRepository;

    public CountryServiceImpl(CountryJdbcRepository countryJdbcRepository) {
        this.countryJdbcRepository = countryJdbcRepository;
    }


    @Override
    public List<CountryDTO> listCountries() {
        return countryJdbcRepository.listCountries();
    }

    @Override
    public Optional<CountryDTO> getCountryById(Integer countryId) {
        return countryJdbcRepository.getCountryById(countryId);
    }

    @Override
    public int save(CountryDTO countryDTO) {
        return countryJdbcRepository.save(countryDTO);
    }

    @Override
    public int delete(Integer countryId) {
        return countryJdbcRepository.delete(countryId);
    }
}
