package com.example.car.controller;

import com.example.car.service.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cars")
public class CarController {

    private CarService carService;
    @PostMapping("")
    public void create(@RequestBody CarDto carDto) {

        carService.create(carDto);
    }
}