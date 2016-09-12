package com.moflying.playground;

import com.moflying.playground.animals.Animal;
import com.moflying.playground.entities.Gender;
import javafx.scene.paint.Color;

public class GenericType {
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
//            GenericType.getObject(Animal.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        GenericType genericType = new GenericType();
        genericType.playContainer();
    }
}


class AnimalGenerator implements MyGenerator<Animal> {
    private Integer index = 0;

    Animal[] animals = new Animal[] {
            new Animal(2, "2", Gender.FEMAIL, Color.BLACK),
            new Animal(5, "5", Gender.FEMAIL, Color.BLACK),
            new Animal(1, "1", Gender.FEMAIL, Color.BLACK),
            new Animal(7, "7", Gender.FEMAIL, Color.BLACK),
            new Animal(4, "4", Gender.FEMAIL, Color.BLACK)
    };

    @Override
    public Boolean hasNext() {
        return index < animals.length;
    }

    @Override
    public Animal next() {
        if (hasNext()) {
            Animal animal = animals[index];
            index += 1;
            return animal;
        }
        return null;
    }

    public static void main(String[] args) {
        AnimalGenerator animalGenerator = new AnimalGenerator();
        while (animalGenerator.hasNext()) {
            System.out.println(animalGenerator.next());
        }
    }
}


interface MyGenerator<T> {
    public Integer index = 0;

    public T next();

    public Boolean hasNext();
}

