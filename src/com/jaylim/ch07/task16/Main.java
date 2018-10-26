package com.jaylim.ch07.task16;

import java.util.*;
import java.util.function.IntFunction;

public class Main {
    public static void main(String[] args) {
        CachedIntegerImmutableList list = new CachedIntegerImmutableList(new IntFunction<Integer>() {
            @Override
            public Integer apply(int value) {
                return value + 1;
            }
        });
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < 150; i++) {
            iterator.next();
        }
        for (int i = 50; i < 120; i++) {
            System.out.println(list.get(i));
        }
    }
}
