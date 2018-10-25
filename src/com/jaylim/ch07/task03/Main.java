package com.jaylim.ch07.task03;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 3; i < 7; i++) {
            set2.add(i);
        }

        //объединение
        //set1.addAll(set2);

        //пересечение
        //set1.retainAll(set2);

        //разность
        set1.removeAll(set2);

        for (Integer integer : set1) {
            System.out.println(integer);
        }
    }
}
