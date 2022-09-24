package com.example.car.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String brand;
    private String licensePlate;
    private STATUS status;

    public Car() {
        // empty
    }
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
