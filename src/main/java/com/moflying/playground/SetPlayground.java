package com.moflying.playground;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetPlayground {
    /**
     * 使用现有的 Array List 初始化 Set
     */
    private static void initializeSetFromArray() {
        Set<Integer> numberSet = new HashSet<>(Arrays.asList(2, 4, 6, 7));

        System.out.println(numberSet);
        System.out.println(numberSet.contains(1));
        System.out.println(numberSet.contains(4));
    }

    public static void main(String[] args) {
        initializeSetFromArray();
    }
}
