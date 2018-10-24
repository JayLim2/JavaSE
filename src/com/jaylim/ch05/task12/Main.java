package com.jaylim.ch05.task12;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        min(1, 5, 7, 11);
    }

    private static int min(int... values) {
        int max = values.length > 0 ? values[0] : 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        IntStream stream = Arrays.stream(values);
        int finalMax = max;
        boolean result = stream.allMatch((val) -> {
            return val <= finalMax;
        });
        assert result : "Incorrect max";
        return max;
    }
}
