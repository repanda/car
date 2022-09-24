package com.example.car.service;

import com.example.car.controller.CarDto;
import com.example.car.domain.Car;
import com.example.car.domain.STATUS;
import org.springframework.stereotype.Service;


@Service
public class CarService {
    public void create(CarDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.brand());
        car.setLicensePlate(carDto.licensePlate());
        car.setStatus(STATUS.valueOf(carDto.status()));
    }
}
