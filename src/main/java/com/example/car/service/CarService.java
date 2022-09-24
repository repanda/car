package com.example.car.service;

import com.example.car.controller.CreateCarRequest;
import com.example.car.domain.Car;
import com.example.car.domain.STATUS;
import com.example.car.repository.CarRepository;
import org.springframework.stereotype.Service;


@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void create(CreateCarRequest createCarRequest) {
        Car car = new Car();
        car.setBrand(createCarRequest.brand());
        car.setLicensePlate(createCarRequest.licensePlate());
        car.setStatus(STATUS.valueOf(createCarRequest.status()));

        carRepository.save(car);
    }
}
