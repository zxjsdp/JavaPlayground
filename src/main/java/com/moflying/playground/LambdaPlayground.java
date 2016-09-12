package com.moflying.playground;

import com.moflying.playground.animals.Animal;
import com.moflying.playground.entities.Gender;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPlayground {
    private static void testSorted() {
        List<Animal> animalList = Arrays.asList(
                new Animal(2, "2", Gender.FEMAIL, Color.BLACK),
                new Animal(5, "5", Gender.FEMAIL, Color.BLACK),
                new Animal(1, "1", Gender.FEMAIL, Color.BLACK),
                new Animal(7, "7", Gender.FEMAIL, Color.BLACK),
                new Animal(4, "4", Gender.FEMAIL, Color.BLACK)
        );

        animalList = animalList.stream().sorted((a, b) -> (a.getName().compareTo(b.getName()))).collect(Collectors.toList());
        System.out.println(animalList);
    }
    public static void main(String[] args) {
        testSorted();
    }
}
