package com.moflying.playground;

import com.moflying.playground.entities.animals.Animal;
import com.moflying.playground.entities.Gender;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class MockitoPlayground {
    public static void playWithMockito() {
        List<Animal> animalList = new ArrayList<Animal>();
//        animalList.sort((animal1, animal2) -> animal1.getName().compareTo(animal2.getName()));
        Animal animal = new Animal();
        animal.setId(2);
        animal.setColor(null);
        animal.setGender(Gender.FEMAIL);
        animal.setName("Tom");

        Long days = ChronoUnit.DAYS.between(LocalDate.parse("2016-05-05"), LocalDate.parse("2016-05-06"));
        System.out.println(days);

//        LinkedList mockedList = mock(LinkedList.class);
//
//        when(mockedList.get(0)).thenReturn("first");
//        when(mockedList.get(1)).thenThrow(new RuntimeException());
//
//        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(1));
    }

    public static void main(String[] args) {
        playWithMockito();
    }
}
