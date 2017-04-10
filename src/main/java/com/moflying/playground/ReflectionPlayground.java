package com.moflying.playground;

import java.lang.reflect.Method;

public class ReflectionPlayground {

    /**
     * Use Reflection to call Java method at runtime
     * @throws Exception Exception
     */
    private static void playWithReflection() throws Exception {
        Class<?> cls = Class.forName("com.moflying.playground.algorithm.string.StringSimilarity");
        Object object = cls.newInstance();

        Class[] paramString = {String.class, String.class};

        Method checkLevenshteinSimilarity =
                cls.getDeclaredMethod("checkLevenshteinSimilarity", paramString);

        Method checkNormalizedLevenshteinSimilarity =
                cls.getDeclaredMethod("checkNormalizedLevenshteinSimilarity", paramString);

        System.out.println(checkLevenshteinSimilarity.invoke(object, "快乐柠檬", "悲伤柠檬"));
        System.out.println(checkNormalizedLevenshteinSimilarity.invoke(object, "快乐柠檬", "悲伤柠檬"));
    }

    public static void main(String[] args) throws Exception {
        playWithReflection();
    }
}
