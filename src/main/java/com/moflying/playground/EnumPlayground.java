package com.moflying.playground;

import com.moflying.playground.entities.Gender;
import com.moflying.playground.utils.EnumUtil;

public class EnumPlayground {
    private static void playEnumCheck() {
        // Result: true
        System.out.println((EnumUtil.enumContains(Gender.class, Gender.MALE)));
        // Result: true
        System.out.println((EnumUtil.enumContains(Gender.class, Gender.FEMAIL)));
        // Result: false
        System.out.println((EnumUtil.enumContains(Gender.class, null)));
        // Result: false
        System.out.println((EnumUtil.enumContains(Gender.class, "MALE")));
        // Result: false
        System.out.println((EnumUtil.enumContains(Gender.class, 1)));
    }

    public static void main(String[] args) {
        playEnumCheck();
    }
}
