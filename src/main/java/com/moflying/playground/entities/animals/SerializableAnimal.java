package com.moflying.playground.entities.animals;

import com.moflying.playground.entities.FoodSalesInfo;
import com.moflying.playground.entities.Gender;
import javafx.scene.paint.Color;

import java.io.Serializable;

public class SerializableAnimal extends Animal implements Serializable {
    private FoodSalesInfo foodSalesInfo;

    public SerializableAnimal() {
    }

    public SerializableAnimal(int id, String name, Gender gender, Color color, FoodSalesInfo foodSalesInfo) {
        super(id, name, gender, color);
        this.foodSalesInfo = foodSalesInfo;
    }

    public FoodSalesInfo getFoodSalesInfo() {
        return foodSalesInfo;
    }

    public void setFoodSalesInfo(FoodSalesInfo foodSalesInfo) {
        this.foodSalesInfo = foodSalesInfo;
    }

    @Override
    public String toString() {
        return String.format("SerializableAnimal{ animal=(ID: %d, Name: %s, Gender: %s, Color: %s), foodSalesInfo=%s }",
                this.getId(), this.getName(), this.getGender(), this.getColor(), foodSalesInfo);
    }
}
