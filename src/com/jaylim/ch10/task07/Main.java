package com.jaylim.ch10.task07;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    private static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent("element " + i, random.nextLong());
        }

        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.println(entry);
        }

        Map.Entry<String, Long> entry = map.reduceEntries(5, new BiFunction<Map.Entry<String, Long>, Map.Entry<String, Long>, Map.Entry<String, Long>>() {
            @Override
            public Map.Entry<String, Long> apply(Map.Entry<String, Long> stringLongEntry, Map.Entry<String, Long> stringLongEntry2) {
                return Long.compare(stringLongEntry.getValue(), stringLongEntry2.getValue()) > 0 ? stringLongEntry : stringLongEntry2;
            }
        });

        System.out.println("\nmax entry:");
        System.out.println(entry);
    }
}
