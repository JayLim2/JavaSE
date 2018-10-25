package com.jaylim.ch07.task01;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = sieve(31);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    public static Set<Integer> sieve(int n) {
        Set<Integer> set = new HashSet<>();

        for (int i = 2; i <= n; i++) {
            set.add(i);
        }

        Integer s = Collections.min(set);
        while (s * s <= n) {
            Set<Integer> toRemoveSet = getRemovedSet(set, s, n);
            set.removeAll(toRemoveSet);
            s++;
        }

        return set;
    }

    private static Set<Integer> getRemovedSet(Set<Integer> set, int s, int n) {
        Set<Integer> result = new HashSet<>();
        int k = 0;
        while (s * (s + k) <= n) {
            result.add(s * (s + k));
            k++;
        }
        return result;
    }
}
