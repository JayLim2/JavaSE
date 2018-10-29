package com.jaylim.ch08.task10;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        words.add("abcdefg");
        words.add("abc");
        words.add("abcd");
        words.add("abcdefghijklmop");
        words.add("edklfdfkdfkdsfp");
        words.add("abcdefghijk");
        words.add("abcdefghijklm");
        words.add("abcde");

        Integer maxLen = words.stream().max(Comparator.comparingInt(String::length)).get().length();
        Stream<String> filtered = words.stream().filter((s) -> s.length() == maxLen);

        filtered.forEach(System.out::println);
    }
}
