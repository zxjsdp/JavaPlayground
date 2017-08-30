package com.moflying.playground;

import com.google.common.collect.Lists;
import com.moflying.playground.entities.animals.Animal;
import org.apache.tools.ant.util.DateUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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

    /**
     * 尝试将一个大的列表以某个大小分割成多个小列表
     */
    private static void playListChunks() {
        List<Integer> bigList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        List<List<Integer>> chunksOne = Lists.partition(bigList, 5);
        // Result: [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [11, 12, 13, 14, 15]]
        System.out.println(chunksOne);

        List<List<Integer>> chunksTwo = Lists.partition(bigList, 10);
        // Result: [[1, 2, 3, 4, 5, 6, 7, 8, 9, 10], [11, 12, 13, 14, 15]]
        System.out.println(chunksTwo);

        List<List<Integer>> chunksThree = Lists.partition(bigList, 20);
        // Result: [[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]]
        System.out.println(chunksThree);

        List<List<Integer>> chunksFour = Lists.partition(bigList, 1);
        // Result: [[1], [2], [3], [4], [5], [6], [7], [8], [9], [10], [11], [12], [13], [14], [15]]
        System.out.println(chunksFour);
    }

    private static void playListIndex() {
        List<Integer> l = Arrays.asList(1);
        System.out.println(l.get(l.size() - 1));
        // Exception in thread "main" java.lang.IllegalArgumentException: fromIndex(0) > toIndex(-1)
        System.out.println(l.subList(0, l.size() - 1));
        System.out.println(l.subList(0, l.size() - 2));
    }

    /**
     * 测试 ArrayList 和 LinkedList 的性能
     */
    private static void playArrayListAndLinkedPerformance() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        int max = 1000000;
        long startTime1 = System.nanoTime();
        for (int i = 0; i < max; i++) {
            arrayList.add(i);
        }
        long endTime1 = System.nanoTime();

        long startTime2 = System.nanoTime();
        for (int i = 0; i < max; i++) {
            linkedList.add(i);
        }
        long endTime2 = System.nanoTime();

        System.out.println("ArrayList:  " + (endTime1 - startTime1));
        System.out.println("LinkedList: " + (endTime2 - startTime2));
    }

    public static void main(String[] args) {
//        playListHelloWorld();
//        playWithAbstractList();
//        getSubList();
//        playListIntersection();
//        playListChunks();
//        playListIndex();
        playArrayListAndLinkedPerformance();
    }
}
