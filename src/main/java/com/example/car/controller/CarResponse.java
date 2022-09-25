package com.example.car.controller;

public record CarResponse(
        long id,
        String brand,
        String licensePlate,
        String status,
        String createdAt,
        String lastUpdatedAt
) {
}
