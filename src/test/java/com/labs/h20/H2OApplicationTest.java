package com.labs.h20;

import com.labs.h20.controller.CountriesController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class H2OApplicationTest {

    public static final Logger logger = LoggerFactory.getLogger(H2OApplicationTest.class);

    @Value("${spring.application.name}")
    private String applicationName;

    @BeforeEach
    void setUp() {
        logger.info("setUp");
    }

    @AfterEach
    void tearDown() {
        logger.info("AfterEach");
    }

    @Test
    void main() {
        logger.info("main {}",applicationName);
    }
}