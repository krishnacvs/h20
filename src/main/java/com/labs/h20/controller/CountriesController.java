package com.labs.h20.controller;

import com.labs.h20.exception.CountryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.labs.h20.models.Country;
import com.labs.h20.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    public static final Logger logger = LoggerFactory.getLogger(CountriesController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping()
    public ResponseEntity<List<Country>> list(){
        var list = countryService.listAllCountries();
        logger.info("CountriesController:: list of {} are found",list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCountryById(@PathVariable Integer id) throws CountryException {
        Optional<Country> country = countryService.findCountryById(id);
        if (country.isEmpty()) {
            logger.error("Country with id {} not found.", id);
            throw new CountryException("Country with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(country);
    }

    @PostMapping()
    public ResponseEntity<?> addCountry(@Valid @RequestBody Country country, Errors errors) throws CountryException {

        if (errors.hasErrors()) {
            throw new CountryException(errors.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }

        boolean CountryExists = countryService.findCountryByName(country.getName()) != null;
        if (CountryExists) {
            logger.error("Unable to create. A Country with name {} already exist", country.getName());
            throw new CountryException("Unable to create. A Country with name " + country.getName() + " already exist.",
                    HttpStatus.CONFLICT);

        }

        countryService.addCountry(country);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(country.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
