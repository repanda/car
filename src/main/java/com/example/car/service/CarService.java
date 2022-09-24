package com.example.car.service;

import com.example.car.controller.CarDto;
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

    public void create(CarDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.brand());
        car.setLicensePlate(carDto.licensePlate());
        car.setStatus(STATUS.valueOf(carDto.status()));

        carRepository.save(car);
    }
}
