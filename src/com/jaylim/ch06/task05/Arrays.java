package com.jaylim.ch06.task05;

import com.jaylim.ch06.task07_08.Pair;

import java.util.ArrayList;

public class Arrays {
    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    /**
     * Chapter 6
     * Task 9
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> Pair<T> firstAndLast(ArrayList<T> list) {
        int size = list.size();
        return new Pair<>(size == 0 ? null : list.get(0), size <= 1 ? null : list.get(size - 1));
    }
}
