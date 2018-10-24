package com.jaylim.ch06.task05;

import com.jaylim.ch06.task07_08.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
    public static <T extends Comparable<T>> Pair<T> firstAndLast(ArrayList<T> list) {
        int size = list.size();
        return new Pair<>(size == 0 ? null : list.get(0), size <= 1 ? null : list.get(size - 1));
    }

    /**
     * Chapter 6
     * Task 10
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T max(ArrayList<T> list) {
        T max = null;
        if (list.size() > 0) {
            max = list.get(0);
            for (T t : list) {
                if (t.compareTo(max) > 0) {
                    max = t;
                }
            }
        }
        return max;
    }

    public static <T extends Comparable<T>> T min(ArrayList<T> list) {
        T min = null;
        if (list.size() > 0) {
            min = list.get(0);
            for (T t : list) {
                if (t.compareTo(min) < 0) {
                    min = t;
                }
            }
        }
        return min;
    }

    /**
     * Chapter 6
     * Task 11
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> Pair<T> minMax(ArrayList<T> list) {
        return new Pair<>(min(list), max(list));
    }

    /**
     * Chapter 6
     * Task 12
     * fixme: 24.10.2018 unresolved
     *
     * @param elements
     * @param cmp
     * @param result
     * @param <T>
     */
    public static <T> void minMax(List<T> elements, Comparator<? super T> cmp, List<? super T> result) {
        Object min = null;
        Object max = null;
        if (elements.size() > 0) {
            min = elements.get(0);
            max = elements.get(0);
            for (T element : elements) {
                /*if(cmp.compare(element, min) < 0) {
                    min = element;
                }
                if(cmp.compare(element, max) > 0) {
                    max = element;
                }*/
            }
        }
    }
}
