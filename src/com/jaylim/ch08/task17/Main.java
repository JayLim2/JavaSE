package com.jaylim.ch08.task17;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
        Данный метод работает только для ПОСЛЕДОВАТЕЛЬНЫХ потоков.
         */

        Stream<Integer> stream = Stream.of(1, 2, 2, 3, 4, 4, 4, 2, 2, 5);
        //stream = stream.parallel();
        List<Integer> list = stream.collect(new Supplier<List<Integer>>() {
            @Override
            public List<Integer> get() {
                return new ArrayList<>();
            }
        }, new BiConsumer<List<Integer>, Integer>() {
            @Override
            public void accept(List<Integer> integers, Integer integer) {
                if (integers.size() == 0 || integers.get(integers.size() - 1).compareTo(integer) != 0) {
                    integers.add(integer);
                }
            }
        }, new BiConsumer<List<Integer>, List<Integer>>() {
            @Override
            public void accept(List<Integer> integers, List<Integer> integers2) {
                integers.addAll(integers2);
            }
        });
        list.forEach(System.out::println);
    }
}
