package com.jaylim.ch07.task15;

import java.util.Iterator;
import java.util.List;
import java.util.function.IntFunction;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = getUnmodifiableList();
        int i = 0;
        for (Integer integer : list) {
            System.out.println(integer);
            if (i++ == 10) return;
        }
    }

    public static List<Integer> getUnmodifiableList() {
        return new IntegerImmutableList(new IntFunction<Integer>() {
            @Override
            public Integer apply(int value) {
                return value * 2 + 1;
            }
        });
    }
}
