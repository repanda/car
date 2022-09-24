package com.example.car.controller;

import com.example.car.service.CarService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("")
    public void create(@RequestBody CarDto carDto) {

        carService.create(carDto);
    }

    @GetMapping("{id}")
    public CarResponse findById(@PathVariable long id) {
        CarResponse savedCar = new CarResponse(
                12345L,
                "Flexa",
                "L-CS8877E",
                "available",
                "2017-09-01T10:23:47.000Z",
                "2022-04-15T13:23:11.000Z"
        );
        return savedCar;
    }
}