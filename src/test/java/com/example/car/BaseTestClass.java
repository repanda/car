package com.example.car;

import com.example.car.controller.CarController;
import com.example.car.domain.Car;
import com.example.car.domain.STATUS;
import com.example.car.repository.CarRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
public class BaseTestClass {

    @Autowired
    private CarController carController;

    @MockBean
    private CarRepository carRepository;
    @Autowired
    WebApplicationContext webApplicationContext;


    @BeforeEach
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(carController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);

        Car savedCar = new Car();

        savedCar.setId(12345L);
        savedCar.setBrand("Flexa");
        savedCar.setLicensePlate("L-CS8877E");
        savedCar.setStatus(STATUS.AVAILABLE);
        savedCar.setCreatedAt(
                LocalDateTime.parse("2017-09-01T10:23:47.000Z", DateTimeFormatter.ISO_ZONED_DATE_TIME)
        );
        savedCar.setLastUpdatedAt(
                LocalDateTime.parse("2022-04-15T13:23:11.000Z", DateTimeFormatter.ISO_ZONED_DATE_TIME)
        );

        when(carRepository.findById(any(Long.class))).thenReturn(Optional.of(savedCar));
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }
}