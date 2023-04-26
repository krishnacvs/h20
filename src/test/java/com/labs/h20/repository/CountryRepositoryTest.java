package com.labs.h20.repository;

import com.labs.h20.models.Country;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("Test")
class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void testSave() {
        Country country1 = new Country();
        country1.setId(6);
        country1.setName("Napal");
        countryRepository.save(country1);
    }
}