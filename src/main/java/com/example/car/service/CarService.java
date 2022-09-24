package com.example.car.service;

import com.example.car.controller.CarResponse;
import com.example.car.controller.CreateCarRequest;
import com.example.car.domain.Car;
import com.example.car.domain.CarNotFoundException;
import com.example.car.domain.STATUS;
import com.example.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {

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

        carRepository.save(car);
    }

    public CarResponse findById(long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(CarNotFoundException::new);

        CarResponse savedCar = new CarResponse(
                car.getId(),
                car.getBrand(),
                car.getLicensePlate(),
                car.getStatus().getLabel(),
                "2017-09-01T10:23:47.000Z",
                "2022-04-15T13:23:11.000Z"
        );

        return savedCar;
    }
}
