package com.moflying.playground.entities.animals;

import com.moflying.playground.entities.Gender;
import javafx.scene.paint.Color;

public class TrueAnimal extends Animal {
    private Boolean isTrueAnimal;

    public TrueAnimal(int id, String name, Gender gender, Color color, Boolean isTrueAnimal) {
        super(id, name, gender, color);
        this.isTrueAnimal = isTrueAnimal;
    }

    public TrueAnimal() {}

    public Boolean getTrueAnimal() {
        return isTrueAnimal;
    }

    public void setTrueAnimal(Boolean trueAnimal) {
        isTrueAnimal = trueAnimal;
    }

    @Override
    public String toString() {
        return "TrueAnimal: " + this.getTrueAnimal();
    }
}
