package com.jaylim.ch06.task07_08;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pair<String> stringPair = new Pair<>("aaa", "bbb");
        System.out.println(stringPair.max());

        Pair<Integer> integerPair = new Pair<>(1, 2);
        System.out.println(integerPair.max());
    }
}
