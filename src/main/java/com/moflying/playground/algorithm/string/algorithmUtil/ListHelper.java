package com.moflying.playground.algorithm.string.algorithmUtil;

import java.util.*;

public class ListHelper {
    public static Boolean hasIntersection(List<String> l1, List<String> l2) {
        return intersection(l1, l2).size() > 0;
    }

    public static Boolean containsSubString(List<String> l1, List<String> l2) {
        String a, b;
        for (List<String> pair : calculate(Arrays.asList(l1, l2))) {
            a = pair.get(0);
            b = pair.get(1);

            if (a.contains(b) || b.contains(a)) {
                return true;
            }
        }

        return false;
    }

    public static <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<>(set);
    }

    public static <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

    public static <T> List<List<T>> calculate(List<List<T>> input) {
        List<List<T>> res = new ArrayList<>();
        if (input.isEmpty()) { // if no more elements to process
            res.add(new ArrayList<>()); // then add empty list and return
            return res;
        } else {
            process(input, res); // we need to calculate the cartesian product of input and store it in res variable
        }
        return res; // method completes , return result
    }

    private static <T> void process(List<List<T>> lists, List<List<T>> res) {
        List<T> head = lists.get(0); //take first element of the list
        List<List<T>> tail = calculate(lists.subList(1, lists.size())); //invoke calculate on remaining element, here is recursion

        for (T h : head) { // for each head
            for (List<T> t : tail) { //iterate over the tail
                List<T> tmp = new ArrayList<>(t.size());
                tmp.add(h); // add the head
                tmp.addAll(t); // and current tail element
                res.add(tmp);
            }
        }
    }

    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("Hello", "world");
        List<String> l2 = Arrays.asList("mo", "orld");
        List<String> l3 = Arrays.asList("world", "molly");

//        System.out.println(calculate(Arrays.asList(Arrays.asList("hello", "world"), Arrays.asList("tom", "mary"))));
        System.out.println(hasIntersection(l1, l2));
        System.out.println(hasIntersection(l1, l3));

    }
}
