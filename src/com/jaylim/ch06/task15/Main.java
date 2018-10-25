package com.jaylim.ch06.task15;

import java.util.ArrayList;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> src = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            src.add(i);
        }
        Function<Integer, String> function = integer -> "integer : " + integer;
        ArrayList<String> result = map(src, function);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static <T, R> ArrayList<R> map(ArrayList<T> list, Function<T, R> function) {
        ArrayList<R> result = new ArrayList<>();

        for (T t : list) {
            result.add(function.apply(t));
        }

        return result;
    }
}
