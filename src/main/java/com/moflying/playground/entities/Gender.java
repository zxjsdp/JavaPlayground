package com.moflying.playground.entities;

public enum Gender {
    MALE(1, "男性"),
    FEMAIL(2, "女性");

    private int index;
    private String description;

    Gender(int index, String description) {
        this.index = index;
        this.description = description;
    }
}
