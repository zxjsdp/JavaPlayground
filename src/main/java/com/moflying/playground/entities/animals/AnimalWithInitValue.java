package com.moflying.playground.entities.animals;

import com.moflying.playground.entities.Gender;
import javafx.scene.paint.Color;

public class AnimalWithInitValue {
    private int id = 1;
    private String name = "John";
    private Gender gender = Gender.FEMALE;
    private Color color = Color.BLACK;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
