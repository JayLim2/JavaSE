package com.jaylim.ch07.task18;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> emptyList1 = Collections.EMPTY_LIST;
        List<Integer> emptyList2 = Collections.emptyList();

        /*
        Константа EMPTY_LIST должна быть приведена к генерик-типу,
        а метод же возвращает уже приведенный пустой список.
         */
    }
}
