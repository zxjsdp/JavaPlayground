package com.moflying.playground;

import com.moflying.playground.animals.Animal;

import java.util.HashMap;
import java.util.Map;

public class MapPlayground {
    public static void main(String[] args) {
        Map<Integer, Animal> animalMap = new HashMap();
        System.out.println(animalMap.get(1));
    }
}
