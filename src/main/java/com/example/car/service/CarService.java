package com.example.car.service;

import com.example.car.controller.CarResponse;
import com.example.car.controller.CreateCarRequest;
import com.example.car.domain.Car;
import com.example.car.domain.CarNotFoundException;
import com.example.car.domain.STATUS;
import com.example.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class CarService {

    public static final DateTimeFormatter ZONED_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void create(CreateCarRequest createCarRequest) {
        Car car = new Car();
        car.setBrand(createCarRequest.brand());
        car.setLicensePlate(createCarRequest.licensePlate());
        car.setStatus(STATUS.valueOf(createCarRequest.status()));
        car.setCreatedAt(LocalDateTime.now());
        car.setLastUpdatedAt(LocalDateTime.now());

        carRepository.save(car);
    }

    public CarResponse findById(long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> {
                    CarNotFoundException carNotFoundException = new CarNotFoundException();
                    return carNotFoundException;
                });

        return mapToCarResponse(car);
    }
    public Collection<CarResponse> findAll() {
        return carRepository.findAll()
                .stream().map(CarService::mapToCarResponse)
                .collect(Collectors.toList());
    }

    private static CarResponse mapToCarResponse(Car car) {
        String createdAt = car.getCreatedAt().format(ZONED_DATE_TIME_FORMATTER);
        String lastUpdatedAt = car.getLastUpdatedAt().format(ZONED_DATE_TIME_FORMATTER);

        CarResponse savedCar = new CarResponse(
                car.getId(),
                car.getBrand(),
                car.getLicensePlate(),
                car.getStatus().getLabel(),
                createdAt,
                lastUpdatedAt
        );
        return savedCar;
    }
}
