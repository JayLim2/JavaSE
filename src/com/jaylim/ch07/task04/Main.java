package com.jaylim.ch07.task04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(i);
        }

        for (Integer integer : list) {
            list.remove(integer); //ConcurrentModificationException
            /*
            Данное исключение возникает при модификации списка во
            время его обхода.

            Если необходимо менять список во время обхода, следует
            явно использовать итератор и его метод remove()
             */
        }
    }
}
