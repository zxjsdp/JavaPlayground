package com.moflying.playground;

public class IntegerPlayground {
    /**
     * 测试使用 `Integer.parseInt` 解析字符串中的 Double 值
     *
     * 会产生 NumberFormatException
     */
    private static void tryToParseIntFromDoubleStr() {
        String num = "8.7";
        try {
            System.out.println(Integer.parseInt(num));
        } catch (NumberFormatException e) {
            // Result:
            //     java.lang.NumberFormatException: For input string: "8.7"
            System.out.println(e);
            // Result:
            //     8.7
            System.out.println(Double.parseDouble(num));
        }
    }

    public static void main(String[] args) {
        tryToParseIntFromDoubleStr();
    }
}
