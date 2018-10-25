package com.jaylim.ch07.task05;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> a;
    }

    public static void swap(List<?> list, int i, int j) {
        if (list.size() > 0) {
            swapHelper(list, i, j);
        }
    }

    private static <T> void swapHelper(List<T> list, int i, int j) {
        if (list instanceof RandomAccess) {
            T o = list.get(i);
            list.set(i, list.get(j));
            list.set(j, o);
        } else {
            T o1 = null;
            T o2 = null;
            Iterator<T> iterator = list.iterator();
            int k = 0;
            int maxIndex = Integer.max(i, j);
            for (T t : list) {
                if (k == maxIndex) {
                    break;
                }
                if (k == i) {
                    o1 = t;
                } else if (k == j) {
                    o2 = t;
                }
                k++;
            }
            list.set(i, o2);
            list.set(j, o1);
        }
    }
}
