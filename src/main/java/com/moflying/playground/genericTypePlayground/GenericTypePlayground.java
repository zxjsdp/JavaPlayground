package com.moflying.playground.genericTypePlayground;

import com.moflying.playground.utils.CollectionUtil;

import java.util.Arrays;
import java.util.List;

public class GenericTypePlayground {
    // 泛型方法
    public static <T> T getObject(Class<T> c) throws Exception {
        T t = c.newInstance();
        System.out.println(t);
        return t;
    }

    // 泛型类
    private class Container<K, V> {
        private K k;
        private V v;

        public Container() {
        }

        public Container(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getK() {
            return k;
        }

        public void setK(K k) {
            this.k = k;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }

        public String toString() {
            return String.format("Container<%s, %s>{k: %s, v: %s}",
                    k.getClass(), v.getClass(), k.toString(), v.toString());
        }
    }

    // 泛型接口
    public void playContainer() {
        Container<String, String> c1 = new Container<>("name", "gender");
        Container<String, Integer> c2 = new Container<>("name", 2);
        Container<Double, String> c3 = new Container<>(13.4, "name");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }

    /**
     * 检查多个应该为正整数的 Integer, Long, Double 值 (shopId, activityId, userId, ...)
     *
     * @param tList 包含多个应该为正整数的 Integer, Long, Double 值
     */
    public static <T> void verifyPositiveNumbers(List<T> tList) {
        if (CollectionUtil.isBlank(tList) || tList.contains(null)) {
            System.out.println("Invalid list. Blank list or null value in list.");
            return;
        }

        tList.forEach(GenericTypePlayground::verifyPositiveNumber);
    }

    public static <T> void verifyPositiveNumber(T t) {
        if (null == t) {
            System.out.printf("%s type is null.\n", t.getClass());
        }
        String numString = t.toString();
        try {
            if (0 >= Double.parseDouble(numString)) {
                System.out.printf("%s type value %s less equals than 0\n", t.getClass(), t.toString());
            }
        } catch (Exception e) {
            System.out.printf("Failed to parse %s type value: %s\n", t.getClass(), t.toString());
        }
    }

    public static void main(String[] args) {
//        try {
//            GenericTypePlayground.getObject(Animal.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        GenericTypePlayground genericTypePlayground = new GenericTypePlayground();
//        genericTypePlayground.playContainer();

        verifyPositiveNumber(new Integer(7));
        verifyPositiveNumbers(Arrays.asList(new Long(-2), null, new Double(5.4), new Integer(-3), new Double(6.2)));
    }
}





