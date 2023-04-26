package com.labs.h20.service;

import com.labs.h20.models.Country;
import com.labs.h20.repository.CountryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class CountryServiceImplTest {

    @Autowired
    private CountryService countryService;

    @MockBean
    private CountryRepository countryRepository;

    @Test
    public void NullTestfindCountryByName() {
        var name = "Napal";
        Country country1 = countryService.findCountryByName(name);
        assertNull(country1);
    }

    @Test
    public void testfindCountryByName() {
        var name = "Napal";
        Country country1 = new Country();
        country1.setId(6);
        country1.setName("Napal");
        given(countryRepository.findByName(any())).willReturn(country1);
        Country country2 = countryService.findCountryByName(name);
        Assertions.assertEquals(country1.getName(),country2.getName());
    }

    @Test
    public void testAddCountry() {
        Country country1 = new Country();
        country1.setId(6);
        country1.setName("Napal");
        when(countryRepository.save(any(Country.class))).thenReturn(country1);
        countryService.addCountry(country1);
        Assertions.assertTrue(true);
    }

}