package com.example.car.controller;

import java.io.Serializable;

public record CreateCarRequest(String brand,
                               String licensePlate,
                               String status) implements Serializable {
}
