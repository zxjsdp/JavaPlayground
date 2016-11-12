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

        // Return null if this map contains no mapping for the key
        // Result: null
        System.out.println(animalMap.get(3));
    }

    /**
     * 尝试遍历打印 Map 数据结构
     */
    static void playIterateOverMap() {
        // result:
        // Key2: Value2
        // Key1: Value1
        // Key3: Value3
        Map<String, String> stringToStringMap = new HashMap<>();
        stringToStringMap.put("Key1", "Value1");
        stringToStringMap.put("Key2", "Value2");
        stringToStringMap.put("Key3", "Value3");
        iterateOverMapV1(stringToStringMap);

        System.out.println("--------------------");

        // result:
        // Key2: Value2
        // Key1: Value1
        // Key3: Value3
        stringToStringMap = new HashMap<>();
        stringToStringMap.put("Key1", "Value1");
        stringToStringMap.put("Key2", "Value2");
        stringToStringMap.put("Key3", "Value3");
        iterateOverMapV2(stringToStringMap);
    }

    /**
     * 遍历 Map 数据结构并打印（方法一）
     *
     * References:
     *   - http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
     *   - http://stackoverflow.com/questions/46898/how-to-efficiently-iterate-over-each-entry-in-a-map
     *
     * @param map Map 数据结构
     */
    static void iterateOverMapV1(Map<String, String> map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            System.out.println(pair.getKey() + ": " + pair.getValue());
            iterator.remove();  // avoids a ConcurrentModificationException
        }
    }

    /**
     * 遍历 Map 数据结构并打印（方法二）
     *
     * References:
     *   - http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
     *   - http://stackoverflow.com/questions/46898/how-to-efficiently-iterate-over-each-entry-in-a-map
     *
     * @param map Map 数据结构
     */
    static void iterateOverMapV2(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    /**
     * Java Map Hello World Example
     */
    static void playMapHelloWorld() {
        Map<Integer, Animal> animalMap = new HashMap();
        animalMap = Animal.generateAnimalMap();

        // result: true
        System.out.println(animalMap.containsKey(1));
        // result: false
        System.out.println(animalMap.containsKey(10));
        // result: Animal    ID: 1, Name: Animal1, Gender: FEMAIL, Color: 0x008000ff
        System.out.println(animalMap.get(1));
        // result: null
        System.out.println(animalMap.get(10));
    }

    /**
     * put duplicate key to map
     * Result:
     *     - Replace value with new one
     */
    private static void playPutDuplicateKeyToMap() {
        Map<Integer, String> aMap = new HashMap<>();
        aMap.put(1, "Hello");
        aMap.put(1, "World");

        // Result: {1=World}
        System.out.println(aMap);
    }

    public static void main(String[] args) {
//        playMapHelloWorld();
//        playListToMapWithTraditionalWay();
//        playListToMapWithLambda();
//        playGetNonExistKey();
//        playIterateOverMap();
        playPutDuplicateKeyToMap();
    }
}
