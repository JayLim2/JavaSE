package com.jaylim.ch02.task04;

import org.omg.CORBA.IntHolder;

public class Main {
    public static void main(String[] args) {
        IntHolder a = new IntHolder(1);
        IntHolder b = new IntHolder(2);
        a.value = 1;
        b.value = 2;
        task4(a, b);
        System.out.println(a.value + " " + b.value);

        System.out.println();
        int a1 = 11;
        int b1 = 22;
        task41(a1, b1);
        System.out.println(a1 + " " + b1);
    }

    /**
     * Chapter 2
     * Task 4
     *
     * @param a
     * @param b
     */
    public static void task4(IntHolder a, IntHolder b) {
        int tmp = b.value;
        b.value = a.value;
        a.value = tmp;
    }

    public static void task41(int a, int b) {
        int tmp = b;
        b = a;
        a = tmp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
