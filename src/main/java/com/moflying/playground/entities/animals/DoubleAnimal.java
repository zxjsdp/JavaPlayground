package com.moflying.playground.entities.animals;

public class DoubleAnimal {
    private Double doubleValue;

    public DoubleAnimal(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public DoubleAnimal() {
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    @Override
    public String toString() {
        return "DoubleAnimal{" +
                "doubleValue=" + doubleValue +
                '}';
    }
}
