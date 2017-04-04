package com.moflying.playground;

import com.moflying.playground.entities.animals.Animal;
import org.apache.commons.lang3.StringUtils;

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

    /**
     * 是否所有元素均为非 null 的、有内容的字符串
     * @param params 元素列表
     * @return 是否所有元素均为非 null 的、有内容的字符串
     */
    private static boolean isAllValidNonBlankString(Object... params) {
        if (null == params) {
            return false;
        }
        try {
            for (Object o : params) {
                if (null == o || !(o instanceof String) || StringUtils.isEmpty(o.toString()))  {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Test methods
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private static void testIsAnyNull() {
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
    }

    private static void testIsAllPositiveInteger() {
        // true
        System.out.println(isAllPositiveInteger(2, 4));
        // false
        System.out.println(isAllPositiveInteger(2, -4));
        // false
        System.out.println(isAllPositiveInteger(2, 1.4));
        // false
        System.out.println(isAllPositiveInteger(2.0, 1));
    }

    private static void testIsAllValidNonBlankString() {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // isAllValidNonblankString
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        String nullString = null;
        String blankString = "";
        String s = "hello";

        System.out.println(isAllValidNonBlankString(s)); // true
        System.out.println(isAllValidNonBlankString(nullString)); // false
        System.out.println(isAllValidNonBlankString(blankString)); // false
        System.out.println(isAllValidNonBlankString(s, nullString)); // false
        System.out.println(isAllValidNonBlankString(s, blankString)); // false
        System.out.println(isAllValidNonBlankString(nullString, blankString)); // false
    }

    public static void main(String[] args) {
//        testIsAnyNull();
//        testIsAllPositiveInteger();
        testIsAllValidNonBlankString();
    }
}
