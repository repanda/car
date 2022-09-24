package com.example.car.controller;

public record CreateCarRequest(String brand,
                               String licensePlate,
                               String status) {
}
