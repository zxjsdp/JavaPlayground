package com.moflying.playground;

import com.moflying.playground.entities.animals.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListPlayground {

    /**
     * List Hello World Example
     */
    private static void playListHelloWorld() {
        List<Animal> animalList = Animal.generateAnimalList();
        System.out.println(animalList);

        System.out.println(animalList.subList(0, 2));

    }

    /**
     * 抽象列表添加元素
     */
    private static void playWithAbstractList() {
        List<Animal> animalList = Animal.generateAnimalList();
        // Should raise java.lang.UnsupportedOperationException
        // AbstractList.add Operation...
        try {
            animalList.addAll(Animal.generateAnimalList());
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException: AbstractList.add ...");
        }

        // Use ArrayList rather than List
        // Won't raise UnsupportedOperationException
        List<Animal> animalArrayList = new ArrayList<>(Animal.generateAnimalList());
        animalArrayList.addAll(new ArrayList<>(Animal.generateAnimalList()));
        System.out.println(animalArrayList);
    }

    /**
     * Improper start index & end index to get sublist of list
     */
    private static void getSubList() {
        List<Animal> animalList = Animal.generateAnimalList();

        System.out.println("Size of Animal list is: " + animalList.size());
        System.out.printf(
                "Sub List [0 - %d): %s\n",
                animalList.size() - 1,
                animalList.subList(0, animalList.size() - 1));
        try {
            System.out.printf(
                    "Sub List [0 - %d): %s",
                    animalList.size() + 1,
                    animalList.subList(0, animalList.size() + 1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        try {
            System.out.printf(
                    "Sub List [size+1 - size+2): %s",
                    animalList.subList(animalList.size() + 1, animalList.size() + 2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    /**
     * List intersection
     */
    private static void playListIntersection() {
        List<Integer> listA = Arrays.asList(1, 2, 3, 4);
        List<Integer> listB = Arrays.asList(3, 4, 5, 6, 7);

        List<Integer> out1 = new ArrayList<>(listA);
        out1.removeAll(listB);
        System.out.println(out1);

        List<Integer> out2 = new ArrayList<>(listB);
        out2.removeAll(listA);
        System.out.println(out2);

        List<Integer> out3 = new ArrayList<>(listA);
        out3.removeAll(listA);
        System.out.println(out3);
    }

    public static void main(String[] args) {
//        playListHelloWorld();
//        playWithAbstractList();
//        getSubList();
        playListIntersection();
    }
}
