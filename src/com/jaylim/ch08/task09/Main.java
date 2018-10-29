package com.jaylim.ch08.task09;

import java.util.HashSet;
import java.util.OptionalDouble;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        words.add("abcdefg");
        words.add("abc");
        words.add("abcd");
        words.add("abcdefghijklmop");
        words.add("abcdefghijk");
        words.add("abcdefghijklm");
        words.add("abcde");
        double canonAvg = 0;
        for (String s : words) {
            canonAvg += s.length();
        }
        canonAvg /= words.size();

        OptionalDouble avg = words.parallelStream().mapToInt((s) -> s.length()).average();

        System.out.println(canonAvg);
        System.out.println(avg.getAsDouble());
    }
}
