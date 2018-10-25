package com.jaylim.ch06.task20;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = repeat(0, 1, 2, 3);
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }

    @SafeVarargs
    public static final <T> T[] repeat(int n, T... objs) {
        T[] result = Arrays.copyOf(objs, n * objs.length);
        for (int i = 0; i < result.length; i += objs.length) {
            for (int j = 0; j < objs.length; j++) {
                result[i + j] = objs[j];
            }
        }
        return result;
    }
}
