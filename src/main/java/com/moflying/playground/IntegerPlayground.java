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

    private void test() {
        A a = new A();
        B b = new B();
        a.setI(b.getI());
        System.out.println(b.getI());
    }

    public static void main(String[] args) {
//        tryToParseIntFromDoubleStr();
        IntegerPlayground playground = new IntegerPlayground();
        playground.test();
    }

    private class A {
        private Integer i;

        public Integer getI() {
            return i;
        }

        public void setI(Integer i) {
            this.i = i;
        }
    }

    private class B {
        private int i;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}
