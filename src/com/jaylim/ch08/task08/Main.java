package com.jaylim.ch08.task08;

import java.io.IOException;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Stream<String> words = com.jaylim.ch08.task07.Main.getWordsStream("task08.txt");
        String[] arr = (String[]) words.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.matches("^(?i:[aeiouy]).*");
            }
        }).toArray();
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
