package com.moflying.playground;

import com.google.common.math.DoubleMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DoublePlayground {
    /**
     * 过滤 Double List 中的 NaN
     */
    private static void playDoubleNaN() {
        List<Double> listWithNaNs = new ArrayList<>();
        listWithNaNs.add(2.3D);
        listWithNaNs.add(Double.NaN);
        listWithNaNs.add(4.5D);

        // [2.3, NaN, 4.5]
        System.out.println(listWithNaNs);

        // This does not work!!
        // [2.3, NaN, 4.5]
        System.out.println(listWithNaNs.stream()
                .filter(num -> Double.NaN != num)
                .collect(Collectors.toList()));

        // This works!!
        // [2.3, 4.5]
        System.out.println(listWithNaNs.stream()
                .filter(num -> !num.equals(Double.NaN))
                .collect(Collectors.toList()));
    }

    /**
     * 测试生成任意多个 NaN
     */
    private static void repeatNaN() {
        Double nan = Double.NaN;
        List<Double> nans = new ArrayList<>();

        nans = Collections.nCopies(5, nan);

        System.out.println(nan);
        System.out.println(nans);
    }

    /**
     * 测试计算空 Double List 的平均值
     */
    private static void playDoubleMean() {
        List<Double> blankDoubleList = new ArrayList<>();
        // Should be: java.lang.IllegalArgumentException: Cannot take mean of 0 values
        System.out.println(DoubleMath.mean(blankDoubleList));
    }

    /**
     * 测试使用 `Double.parseDouble` 及 `Double.valueOf` 解析字符串中的 Double 或 Integer 值
     */
    private static void doubleParse() {
        String doubleStr = "8.72";
        String intStr = "90";

        System.out.println(Double.parseDouble(doubleStr));
        System.out.println(Double.valueOf(doubleStr));
        System.out.println(Double.parseDouble(intStr));
        System.out.println(Double.valueOf(intStr));
    }

    public static void main(String[] args) {
//        playDoubleNaN();
//        playDoubleMean();
//        repeatNaN();
        doubleParse();
    }
}
