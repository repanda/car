package com.example.car.controller;

public record CarDto(String brand,
                     String licensePlate,
                     STATUS status) {

    enum STATUS {
        AVAILABLE("available");

        private String label;

        STATUS(String label) {
            this.label = label;
        }
    }
}
