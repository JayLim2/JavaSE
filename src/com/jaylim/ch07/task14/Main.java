package com.jaylim.ch07.task14;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = getUnmodifiableList(5);
        /*for (Integer integer : list) {
            System.out.println(integer);
        }*/
        System.out.println(list.get(3));
        System.out.println(list.get(7));
        list.add(100);
    }

    public static List<Integer> getUnmodifiableList(int n) {
        return new NaturalNumbersImmutableList(n);
    }
}
