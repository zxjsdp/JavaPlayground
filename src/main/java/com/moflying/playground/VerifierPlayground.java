package com.moflying.playground;

import com.moflying.playground.entities.animals.Animal;

public class VerifierPlayground {
    /**
     * 检测多个元素中是否有至少一个为 null
     * @param params 需要检查的元素列表
     * @return 是否有至少一个为 null
     */
    public static boolean isAnyNull(Object... params) {
        if (null == params) {
            return true;
        }
        for (Object o : params) {
            if (null == o) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查是否所有的元素均为正整数
     * @param params 需要检查的元素
     * @return 是否所有的元素均为正整数
     */
    public static boolean isAllPositiveInteger(Object... params) {
        if (null == params) {
            return false;
        }
        try {
            for (Object o : params) {
                if ((int) o <= 0 || !(o instanceof Integer)) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // true
        System.out.println(isAnyNull(null));
        // true
        System.out.println(isAnyNull(null, null));
        try {
            Animal animal = null;
            // java.lang.NullPointerException
            System.out.println(isAnyNull(animal, animal.getColor()));
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        // true
        System.out.println(isAllPositiveInteger(2, 4));
        // false
        System.out.println(isAllPositiveInteger(2, -4));
        // false
        System.out.println(isAllPositiveInteger(2, 1.4));
        // false
        System.out.println(isAllPositiveInteger(2.0, 1));
    }
}
