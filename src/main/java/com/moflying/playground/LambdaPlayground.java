package com.moflying.playground;

import com.moflying.playground.animals.Animal;
import com.moflying.playground.entities.Gender;
import javafx.scene.paint.Color;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaPlayground {
    /**
     * 使用 Lambda 表达式，基于结构体中的某个字段进行排序
     */
    private static void sortWithLambdaExpression() {
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

    public static void main(String[] args) {
//        sortWithLambdaExpression();
        uniquifyListByIdWithLambda();
    }
}
