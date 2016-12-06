package com.moflying.playground.entities.animals;

import java.util.List;

public class AnimalWithNumber {
    private Integer number;
    private List<Animal> animalList;

    public AnimalWithNumber() {}

    public AnimalWithNumber(Integer number, List<Animal> animalList) {
        this.number = number;
        this.animalList = animalList;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
