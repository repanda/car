package com.example.car.controller;

import com.example.car.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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

    @GetMapping
    public Collection<CarResponse> all() {

        return carService.findAll();
    }
}