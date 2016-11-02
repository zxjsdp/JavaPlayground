package com.moflying.playground;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionPlayground {
    /**
     * 使用正则表达式从字符串中解析数字列表
     */
    private static void parseNumbers() {
        String someSentence = "这30张洁白的纸上有从-10到20的数字";
        Pattern numberP = Pattern.compile("-?\\d+");
        List<Integer> numbers = new ArrayList<>();
        Matcher m = numberP.matcher(someSentence);
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }

        System.out.println(numbers);
    }

    public static void main(String[] args) {
        parseNumbers();
    }
}
