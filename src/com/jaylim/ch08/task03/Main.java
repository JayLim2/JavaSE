package com.jaylim.ch08.task03;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<int[]> stream = method(1, 4, 9, 16);
        IntStream intStream = method2(1, 4, 9, 16);
    }

    public static Stream<int[]> method(int... values) {
        return Stream.of(values);
    }

    public static IntStream method2(int... values) {
        return IntStream.of(values);
    }
}
