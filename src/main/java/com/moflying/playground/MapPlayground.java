package com.moflying.playground;

import com.moflying.playground.animals.Animal;

import java.util.*;
import java.util.stream.Collectors;

public class MapPlayground {
    /**
     * 将 List 转换为 Map（传统方式）
     */
    static void playListToMapWithTraditionalWay() {
        List<Animal> animals = Animal.generateAnimalList();
        Map<Integer, Animal> idToAnimalMap = new HashMap<>();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // 将 value 定义为 Animal
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        for (Animal animal : animals) {
            idToAnimalMap.put(animal.getId(), animal);
        }
        System.out.println(idToAnimalMap);

        // 重复 key，会覆盖原有 key 所具有的 value
        // 应该将 value 定义为 List<Animal>
        for (Animal animal : animals) {
            idToAnimalMap.put(animal.getId(), animal);
        }
        System.out.println(idToAnimalMap);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // 将 value 定义为 List<Animal>
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Map<Integer, List<Animal>> idToAnimalListMap = new HashMap<>();
        List<Animal> animalList;
        for (Animal animal : animals) {
            if (idToAnimalListMap.containsKey(animal.getId())) {
                animalList = idToAnimalListMap.get(animal.getId());
                animalList.add(animal);
                idToAnimalListMap.put(animal.getId(), animalList);
            } else {
                idToAnimalListMap.put(
                        animal.getId(),
                        new ArrayList<>(Collections.singleton(animal)));
            }
        }
        for (Animal animal : animals.subList(0, animals.size() / 2)) {
            if (idToAnimalListMap.containsKey(animal.getId())) {
                animalList = idToAnimalListMap.get(animal.getId());
                animalList.add(animal);
                idToAnimalListMap.put(animal.getId(), animalList);
            } else {
                idToAnimalListMap.put(
                        animal.getId(),
                        new ArrayList<>(Collections.singleton(animal)));
            }
        }
        System.out.println(idToAnimalListMap);
    }

    /**
     * 将 List 转换为 Map（Lambda 方式）
     */
    static void playListToMapWithLambda() {
        List<Animal> animals = Animal.generateAnimalList();

        // key 无重复，value 为单一值
        Map<Integer, Animal> animalMap = animals.stream().collect(Collectors.toMap(Animal::getId, animal -> animal));
        System.out.println(animalMap);

        // key 有重复，value 为 List
        Map<Integer, List<Animal>> animalListMap = animals.stream().collect(Collectors.groupingBy(Animal::getId));
        System.out.println(animalListMap);
    }


    /**
     * 尝试活动 Map 中不存在的 key
     */
    static void playGetNonExistKey() {
        Map<Integer, Animal> animalMap = new HashMap<>();

        System.out.println(animalMap.get(3));
    }

    /**
     * Java Map Hello World Example
     */
    static void playMapHelloWorld() {
        Map<Integer, Animal> animalMap = new HashMap();
        animalMap = Animal.generateAnimalMap();

        System.out.println(animalMap.containsKey(1));
        System.out.println(animalMap.containsKey(10));
        System.out.println(animalMap.get(1));
        System.out.println(animalMap.get(10));
    }

    public static void main(String[] args) {
//        playMapHelloWorld();
//        playListToMapWithTraditionalWay();
        playListToMapWithLambda();
    }
}
