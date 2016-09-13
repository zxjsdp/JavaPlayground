package com.moflying.playground.animals;


import com.moflying.playground.entities.Gender;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Animal {
    private int id;
    private String name;
    private Gender gender;
    private Color color;

    public Animal() {
    }

    public Animal(int id, String name, Gender gender, Color color) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.color = color;
    }

    /**
     * 产生测试 Animal List
     *
     * @return 测试 Animal List
     */
    public static List<Animal> generateAnimalList() {
        return Arrays.asList(
                new Animal(2, "2", Gender.FEMAIL, Color.BLACK),
                new Animal(5, "5", Gender.FEMAIL, Color.BLACK),
                new Animal(1, "1", Gender.FEMAIL, Color.BLACK),
                new Animal(7, "7", Gender.FEMAIL, Color.BLACK),
                new Animal(4, "4", Gender.FEMAIL, Color.BLACK)
        );
    }

    /**
     * 产生测试 Animal Map
     *
     * @return 测试 Animal Map 数据
     */
    public static Map<Integer, Animal> generateAnimalMap() {
        List<Animal> animalList = generateAnimalList();
        return animalList.stream()
                .collect(Collectors.toMap(Animal::getId, animal -> animal));
    }

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

    @Override
    public String toString() {
        return String.format("Animal (ID: %d, Name: %s, Gender: %s, Color: %s)",
                this.id, this.name, this.gender, this.color);
    }
}
