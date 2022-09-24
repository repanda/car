package com.example.car.domain;

public enum STATUS {
    AVAILABLE("available");

    private String label;

    STATUS(String label) {
        this.label = label;
    }
}