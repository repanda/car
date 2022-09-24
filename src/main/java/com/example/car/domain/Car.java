package com.example.car.domain;

import com.example.car.controller.CarDto;

import java.time.LocalDate;

public class Car {
    private Long id;

    private String brand;
    private String licensePlate;
    private STATUS status;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }
}
