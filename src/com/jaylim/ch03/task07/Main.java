package com.jaylim.ch03.task07;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        luckySort("bbb", "aba", "efe", "eef", "abacum", "caba");
    }

    public static void luckySort(String... strings) {
        luckySort(Arrays.asList(strings), String::compareTo);
    }

    public static void luckySort(List<String> strings, Comparator<String> cmp) {
        int size = strings.size();
        if (size < 2) {
            System.out.println("List with one elem.");
            return;
        } else {
            while (true) {
                boolean isSorted = true;
                for (int j = 1; j < size && isSorted; j++) {
                    if (cmp.compare(strings.get(j), strings.get(j - 1)) < 0) {
                        isSorted = false;
                    }
                }

                if (!isSorted) {
                    Collections.shuffle(strings);
                } else {
                    for (String string : strings) {
                        System.out.println(string);
                    }
                    return;
                }
            }
        }
    }
}
