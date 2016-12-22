package com.moflying.playground.utils;

public class EnumUtil {
    public static boolean enumContains(Class<? extends Enum> enumClass, Object obj) {
        if (null == enumClass || null == obj) {
            return false;
        }

        if (!enumClass.equals(obj.getClass())) {
            return false;
        }

        Object[] arr = enumClass.getEnumConstants();
        for (Object a : arr) {
            if (((Enum) a).name().equals(obj.toString())) {
                return true;
            }
        }
        return false;
    }
}
