package com.moflying.playground.genericTypePlayground;

import com.moflying.playground.animals.Animal;
import com.moflying.playground.entities.Gender;
import javafx.scene.paint.Color;

class AnimalGenerator implements MyGenerator<Animal> {
    private Integer index = 0;

    private Animal[] animals = new Animal[] {
            new Animal(2, "2", Gender.FEMAIL, Color.BLACK),
            new Animal(5, "5", Gender.MALE, Color.RED),
            new Animal(1, "1", Gender.FEMAIL, Color.GRAY),
            new Animal(7, "7", Gender.MALE, Color.GREEN),
            new Animal(4, "4", Gender.FEMAIL, Color.BLUE)
    };

    @Override
    public Boolean hasNext() {
        return index < animals.length;
    }

    @Override
    public Animal next() {
        if (hasNext()) {
            Animal animal = animals[index];
            index += 1;
            return animal;
        }
        return null;
    }

    public static void main(String[] args) {
        AnimalGenerator animalGenerator = new AnimalGenerator();
        while (animalGenerator.hasNext()) {
            System.out.println(animalGenerator.next());
        }
    }
}

