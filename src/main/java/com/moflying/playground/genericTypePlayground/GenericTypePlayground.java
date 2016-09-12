package com.moflying.playground.genericTypePlayground;

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

    public static void main(String[] args) {
//        try {
//            GenericTypePlayground.getObject(Animal.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        GenericTypePlayground genericTypePlayground = new GenericTypePlayground();
        genericTypePlayground.playContainer();
    }
}





