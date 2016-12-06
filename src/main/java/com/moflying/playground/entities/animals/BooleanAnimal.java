package com.moflying.playground.entities.animals;

public class BooleanAnimal {
    private Boolean boolValue;

    public BooleanAnimal(Boolean boolValue) {
        this.boolValue = boolValue;
    }

    public BooleanAnimal() {
    }

    public Boolean getBoolValue() {
        return boolValue;
    }

    public void setBoolValue(Boolean boolValue) {
        this.boolValue = boolValue;
    }

    @Override
    public String toString() {
        return "BooleanAnimal: " + this.boolValue;
    }
}
