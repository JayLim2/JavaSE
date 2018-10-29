package com.jaylim.ch08.task05;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String s = "testString";
        Stream<Character> characterStream = Stream.iterate(0, integer -> integer + 1).limit(s.length()).map(s::charAt);
        characterStream.forEach(System.out::println);
    }
}
