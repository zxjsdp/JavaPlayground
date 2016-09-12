package com.moflying.playground;

import com.moflying.playground.animals.Animal;

import java.util.List;

public class ListPlayGroud {
    private static void playList() {
        List<Animal> animalList = Animal.generateAnimalList();
        System.out.println(animalList);

        System.out.println(animalList.subList(0, 2));

    }
    public static void main(String[] args) {
        playList();
    }
}
