package com.moflying.playground;

import com.moflying.playground.entities.Gender;
import com.moflying.playground.entities.animals.Animal;
import com.moflying.playground.entities.animals.BooleanAnimal;
import com.moflying.playground.entities.animals.IntegerAnimal;
import javafx.scene.paint.Color;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaPlayground {
    /**
     * Extract list of specific fields from list of objects with lambda map
     */
    private static void playExtractListOfFieldFromListOfStruct() {
        List<Animal> animalList = Animal.generateAnimalList();

        List<Gender> animalGender = animalList.stream()
                .map(Animal::getGender)
                .collect(Collectors.toList());

        System.out.println(animalGender);
    }

    /**
     * 使用 Lambda 表达式，基于结构体中的某个字段进行排序
     */
    private static void sortWithLambdaExpression() {
        List<Animal> animalList = Arrays.asList(
                new Animal(2, "2", Gender.FEMALE, Color.BLACK),
                new Animal(5, "5", Gender.FEMALE, Color.BLACK),
                new Animal(1, "1", Gender.FEMALE, Color.BLACK),
                new Animal(7, "7", Gender.FEMALE, Color.BLACK),
                new Animal(4, "4", Gender.FEMALE, Color.BLACK)
        );

        animalList = animalList.stream().sorted((a, b) -> (a.getName().compareTo(b.getName()))).collect(Collectors.toList());
        System.out.println(animalList);
    }

    /**
     * 根据结构体中布尔型字段排序的顺序
     */
    private static void sortByBooleanField() {
        List<BooleanAnimal> animalList = Arrays.asList(
                new BooleanAnimal(true),
                new BooleanAnimal(false),
                new BooleanAnimal(true),
                new BooleanAnimal(false));

        // [BooleanAnimal: false,
        //  BooleanAnimal: false,
        //  BooleanAnimal: true,
        //  BooleanAnimal: true]
        List<BooleanAnimal> falseAnimalsFirstList1 = animalList.stream()
                .sorted((a1, a2) -> Boolean.compare(a1.getBoolValue(), a2.getBoolValue()))
                .collect(Collectors.toList());

        // [BooleanAnimal: false,
        //  BooleanAnimal: false,
        //  BooleanAnimal: true,
        //  BooleanAnimal: true]
        List<BooleanAnimal> falseAnimalsFirstList2 = animalList.stream()
                .sorted(Comparator.comparing(BooleanAnimal::getBoolValue))
                .collect(Collectors.toList());

        // [TrueAnimal: true,
        //  TrueAnimal: true,
        //  TrueAnimal: false,
        //  TrueAnimal: false]
        List<BooleanAnimal> trueAnimalsFirstList = animalList.stream()
                .sorted((a1, a2) -> Boolean.compare(a2.getBoolValue(), a1.getBoolValue()))
                .collect(Collectors.toList());

        System.out.println(falseAnimalsFirstList1);
        System.out.println(falseAnimalsFirstList2);
        System.out.println(trueAnimalsFirstList);
    }

    /**
     * 使用 Lambda 表达式，根据结构体中的 ID 字段去重
     */
    private static void uniquifyListByIdWithLambda() {
        List<Animal> animalList = new ArrayList<>(Animal.generateAnimalList());
        animalList.addAll(Animal.generateAnimalList());
        System.out.println(animalList.size());

        Set<Integer> idSet = new HashSet<>();
        List<Animal> uniqueAnimalList = animalList.stream()
                .filter(animal -> !idSet.contains(animal.getId()) && idSet.add(animal.getId()))
                .collect(Collectors.toList());

        System.out.println(uniqueAnimalList.size());
    }

    /**
     * 获取结构体中某个列表类型对象的列表数目
     */
    private static void countSublistInList() {
        List<IntegerAnimal> animalWithNumberList = new ArrayList<>();
        animalWithNumberList.add(new IntegerAnimal(0, Animal.generateAnimalList()));
        animalWithNumberList.add(new IntegerAnimal(0, Animal.generateAnimalList()));
        animalWithNumberList.add(new IntegerAnimal(0, Animal.generateAnimalList()));
        animalWithNumberList.add(new IntegerAnimal(0, Animal.generateAnimalList()));

        // Result: 4
        System.out.println(animalWithNumberList.stream()
                .map(IntegerAnimal::getAnimalList)
                .collect(Collectors.toList())
                .size());
    }

    public static void main(String[] args) {
//        playExtractListOfFieldFromListOfStruct();
//        sortWithLambdaExpression();
        sortByBooleanField();
//        uniquifyListByIdWithLambda();
//        countSublistInList();
    }
}
