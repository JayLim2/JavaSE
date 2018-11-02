package com.jaylim.ch12.task02;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2000, 2, 29);
        LocalDate test1 = date.plusYears(1);
        LocalDate test2 = date.plusYears(4);
        LocalDate test3 = date.plusYears(1).plusYears(1).plusYears(1).plusYears(1);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }
}
