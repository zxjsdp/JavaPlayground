package com.moflying.playground;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

    /**
     * 尝试从 null 的 List 初始化 Set
     *
     * Result:
     *     NullPointerException
     */
    private static void initSetFromNullList() {
        List<Integer> nullList = null;

        try {
            Set<Integer> nullSet = new HashSet<>(nullList);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
//        initializeSetFromArray();
        initSetFromNullList();
    }
}
