package com.diplomado.courses.web.rest;

import com.diplomado.courses.dto.CountryDTO;
import com.diplomado.courses.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> listAllCountries() {
        return ResponseEntity
                .ok()
                .body(countryService.listCountries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok()
                .body(countryService.getCountryById(id).orElseThrow(() -> new IllegalArgumentException()));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody final CountryDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new country cannot already have an id.");
        }

        countryService.save(dto);

        return ResponseEntity
                .created(null)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        countryService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
