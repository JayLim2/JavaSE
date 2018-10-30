package com.jaylim.ch08.task13;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            l1.add(i);
        }
        ArrayList<Integer> l2 = new ArrayList<>();
        for (int i = 4; i < 17; i++) {
            l2.add(i);
        }
        ArrayList<Integer> l3 = new ArrayList<>();
        for (int i = 2; i < 8; i++) {
            l3.add(i);
        }
        Stream<ArrayList<Integer>> stream = Stream.of(l1, l2, l3);
        //Stream<ArrayList<Integer>> stream = Stream.of();
        ArrayList<Integer> result = join3(stream);
        result.sort(Integer::compareTo);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static <T> ArrayList<T> join(Stream<ArrayList<T>> stream) {
        ArrayList<T> result = new ArrayList<>();
        stream.reduce(result, new BinaryOperator<ArrayList<T>>() {
            @Override
            public ArrayList<T> apply(ArrayList<T> list1, ArrayList<T> list2) {
                list1.addAll(list2);
                return list1;
            }
        });
        return result;
    }

    public static <T> ArrayList<T> join2(Stream<ArrayList<T>> stream) {
        Optional<ArrayList<T>> result = stream.reduce(new BinaryOperator<ArrayList<T>>() {
            @Override
            public ArrayList<T> apply(ArrayList<T> list1, ArrayList<T> list2) {
                list1.addAll(list2);
                return list1;
            }
        });
        return result.orElseGet(ArrayList::new);
    }

    public static <T> ArrayList<T> join3(Stream<ArrayList<T>> stream) {
        return stream.reduce(
                new ArrayList<>(),

                (result, list1) -> {
                    result.addAll(list1);
                    return result;
                },

                (result1, result2) -> {
                    result1.addAll(result2);
                    return result1;
                }
        );
    }
}
