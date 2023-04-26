package com.labs.h20.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labs.h20.service.CountryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestPropertySource("/application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
class CountriesControllerTest {

    public static final Logger logger = LoggerFactory.getLogger(CountriesControllerTest.class);

    private MockHttpServletRequest request;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CountryService countryService;

    @Autowired
    private ObjectMapper objectMapper;

    public static final MediaType APPLICATION_JSON = MediaType.APPLICATION_JSON;

    @BeforeEach
    void setUp() {
        logger.info("setUp");
        request = new MockHttpServletRequest();
    }

    @AfterEach
    void tearDown() {
        logger.info("tearDown");
    }

    @Test
    void list() throws Exception {
        logger.info("list");
        var response = mockMvc.perform(MockMvcRequestBuilders.get("/countries"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON));
    }

    @Test
    void findCountryById() {
        logger.info("findCountryById");
    }

    @Test
    void addCountry() {
        logger.info("addCountry");
    }
}