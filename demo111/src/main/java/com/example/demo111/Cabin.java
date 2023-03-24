package com.example.demo111;

public class Cabin {
    private int cabinNumber;
    private String cabinType;

    public Cabin(int cabinNumber, String cabinType) {
        this.cabinNumber = cabinNumber;
        this.cabinType = cabinType;
    }

    public int getCabinNumber() {
        return cabinNumber;
    }

    public String getCabinType() {
        return cabinType;
    }
}
