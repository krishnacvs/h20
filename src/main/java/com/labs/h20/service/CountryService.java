package com.labs.h20.service;

import com.labs.h20.models.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    public Country findCountryByName(String name);

    public Optional<Country> findCountryById(Integer id);

    public List<Country> listAllCountries();

    void addCountry(Country country);
}
