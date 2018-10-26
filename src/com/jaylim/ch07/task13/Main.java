package com.jaylim.ch07.task13;

public class Main {
    public static void main(String[] args) {
        Cache<String, Integer> cache = new Cache<>(5);
        for (int i = 0; i < 6; i++) {
            cache.put("string " + i, i);
        }
    }
}
