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
    public void create(@RequestBody CreateCarRequest carDto) {

        carService.create(carDto);
    }

    @GetMapping("{id}")
    public CarResponse findById(@PathVariable long id) {

        return carService.findById(id);
    }
}