package com.jaylim.ch08.task04;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Generator {
    public static void main(String[] args) {
        Stream<Long> generator = generator(10, 25214903917L, 11, Math.round(Math.pow(2, 48)));
        generator.limit(10).forEach(System.out::println);
    }

    public static Stream<Long> generator(long x0, long a, long c, long m) {
        Stream<Long> generator = Stream.iterate(x0, new UnaryOperator<Long>() {
            @Override
            public Long apply(Long x) {
                return (a * x + c) % m;
            }
        });

        return generator;
    }
}
