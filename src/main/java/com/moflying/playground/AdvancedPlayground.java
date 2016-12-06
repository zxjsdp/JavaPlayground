package com.moflying.playground;

import com.moflying.playground.entities.animals.Animal;
import com.moflying.playground.entities.Gender;
import javafx.scene.paint.Color;

import java.lang.reflect.Field;

public class AdvancedPlayground {
    /**
     * 遍历类中的所有域
     */
    private static void iterateAllFieldsInClass() {
        Animal animal = new Animal(3, "Tom", Gender.MALE, Color.RED);

        Field[] fields = animal.getClass().getDeclaredFields();

        for (Field field : fields) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(field);
            System.out.println(field.getClass());
            System.out.println(field.getType());
            System.out.println(field.getName());
            System.out.println(field.getName().equals("id"));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    public static void main(String[] args) {
        iterateAllFieldsInClass();
    }
}
