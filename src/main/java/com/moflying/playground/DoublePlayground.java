package com.moflying.playground;

import com.google.common.math.DoubleMath;
import com.moflying.playground.entities.animals.DoubleAnimal;

import java.util.*;
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
     * 测试计算空 Double List 的平均值
     */
    private static void playDoubleMean() {
        List<Double> blankDoubleList = new ArrayList<>();

        // Result:
        //     java.lang.IllegalArgumentException: Cannot take mean of 0 values
        try {
            System.out.println(DoubleMath.mean(blankDoubleList));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    /**
     * 测试生成任意多个 NaN
     */
    private static void playNaNRepeating() {
        Double nan = Double.NaN;
        List<Double> nans = new ArrayList<>();

        nans = Collections.nCopies(5, nan);

        System.out.println(nan);
        System.out.println(nans);
    }

    /**
     * 测试使用 `Double.parseDouble` 及 `Double.valueOf` 解析字符串中的 Double 或 Integer 值
     */
    private static void playParseDouble() {
        String doubleStr = "8.72";
        String intStr = "90";

        // Result: 8.72
        System.out.println(Double.parseDouble(doubleStr));
        // Result: 8.72
        System.out.println(Double.valueOf(doubleStr));
        // Result: 90.0
        System.out.println(Double.parseDouble(intStr));
        // Result: 90.0
        System.out.println(Double.valueOf(intStr));
    }

    /**
     * Display Double value in formatted string.
     */
    private static void playFormatDoubleInString() {
        Double money = 8.372815;

        // Result: Money is $8.37.
        String moneyString = String.format("Money is $%.2f.", money);

        System.out.println(moneyString);
    }

    /**
     * 使用 Comparator.comparingDouble 来根据结构体中的 Double 字段进行排序
     */
    private static void sortDoubleWithComparitors() {
        List<DoubleAnimal> doubleAnimalList = Arrays.asList(
                new DoubleAnimal(3.5),
                new DoubleAnimal(6.7),
                new DoubleAnimal(2.3),
                new DoubleAnimal(7.9)
        );

        List<DoubleAnimal> sortedDoubleAnimal = doubleAnimalList.stream()
                .sorted(Comparator.comparingDouble(DoubleAnimal::getDoubleValue))
                .collect(Collectors.toList());

        // [
        //     DoubleAnimal{doubleValue=2.3},
        //     DoubleAnimal{doubleValue=3.5},
        //     DoubleAnimal{doubleValue=6.7},
        //     DoubleAnimal{doubleValue=7.9}
        // ]
        System.out.println(sortedDoubleAnimal);
    }

    public static void main(String[] args) {
//        playDoubleNaN();
//        playDoubleMean();
//        playNaNRepeating();
//        playParseDouble();
//        playFormatDoubleInString();
        sortDoubleWithComparitors();
    }
}
