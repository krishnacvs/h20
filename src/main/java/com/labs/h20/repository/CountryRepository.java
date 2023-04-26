package com.labs.h20.repository;

import com.labs.h20.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {

       Country findByName(String name);
}
