package com.jaylim.ch08.task17;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 2, 3, 4, 4, 4, 5);
        stream.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return stream.findAny().isPresent();
            }
        }).forEach(System.out::println);
        // FIXME: 10/30/2018 unresolved
    }
}
