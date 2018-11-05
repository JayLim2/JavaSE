package com.jaylim.ch08.task12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> second = Stream.of(7, 8);
        zip(first, second).forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        ArrayList<T> list = new ArrayList<>();
        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());
        int size = Integer.max(firstList.size(), secondList.size());
        for (int i = 0; i < size; i++) {
            list.add(i < firstList.size() ? firstList.get(i) : null);
            list.add(i < secondList.size() ? secondList.get(i) : null);
        }
        return list.stream();
    }
}
