package com.labs.h20.service;

import com.labs.h20.models.Country;
import com.labs.h20.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country findCountryByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public Optional<Country> findCountryById(Integer id) {
        return countryRepository.findById(id);
    }

    @Override
    public List<Country> listAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

}
