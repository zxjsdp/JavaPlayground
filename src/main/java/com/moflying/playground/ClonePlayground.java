package com.moflying.playground;

import com.moflying.playground.entities.FoodSalesInfo;
import com.moflying.playground.entities.Gender;
import com.moflying.playground.entities.animals.Animal;
import com.moflying.playground.entities.animals.SerializableAnimal;
import javafx.scene.paint.Color;
import org.apache.commons.lang3.SerializationUtils;

import java.util.List;

/**
 * Clone playground
 */
public class ClonePlayground {
    /**
     * 使用 org.apache.commons.lang.SerializationUtils 进行 Object clone
     * 前提条件：待 clone 的 class 需要 implement Serializable
     * Reference: http://stackoverflow.com/a/16346442/5305925
     */
    private static void playCloneWithSerializationUtils() {
        List<Animal> animalList = Animal.generateAnimalList();
        SerializableAnimal original = new SerializableAnimal(
                1,
                "Original Animal",
                Gender.FEMALE,
                Color.RED,
                new FoodSalesInfo(123, "FoodSalesInfo original", 1));

        SerializableAnimal clone = SerializationUtils.clone(original);

        // result: false
        System.out.println(original.equals(clone));

        clone.setName("Updated Name");
        clone.setId(2);
        clone.setGender(Gender.MALE);
        clone.setColor(Color.BLACK);
        clone.setFoodSalesInfo(new FoodSalesInfo(456, "FoodSalesInfo new", 2));

        // result:
        // original: SerializableAnimal{
        //     animal=(
        //         ID: 1,
        //         Name: Original Animal,
        //         Gender: FEMALE,
        //         Color: 0xff0000ff),
        //     foodSalesInfo=FoodSalesInfo{foodId=123, foodName='FoodSalesInfo original', totalSalesVolume=1} }
        System.out.println("original: " + original);

        // result:
        // clone: SerializableAnimal{
        //     animal=(
        //         ID: 2,
        //         Name: Updated Name,
        //         Gender: MALE,
        //         Color: 0x000000ff),
        //     foodSalesInfo=FoodSalesInfo{foodId=456, foodName='FoodSalesInfo new', totalSalesVolume=2} }
        System.out.println("clone: " + clone);
    }

    public static void main(String[] args) throws Exception {
        playCloneWithSerializationUtils();
    }
}
