package com.jaylim.ch02.task01;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        task1();
        System.out.println("\n");
        task11();
    }

    /**
     * Chapter 2
     * Task 1
     * Calendar
     */
    public static void task1() {
        int year = 2018;
        int month = 11;
        int day = 1;
        LocalDate date = LocalDate.of(year, month, 1);

        System.out.printf("%2s %2s %2s %2s %2s %2s %2s %n", "Mo", "Tu", "We", "Th", "Fr", "Sa", "Su");

        while (date.getMonthValue() == month) {
            int value = date.getDayOfWeek().getValue();

            if (date.getDayOfMonth() == 1) {
                for (int i = 1; i < value; i++) {
                    System.out.printf("%2s ", "");
                }
            }

            System.out.printf("%2d ", date.getDayOfMonth());

            if (value == 7) {
                System.out.println();
            }

            date = date.plusDays(1);
        }
    }

    /**
     * Chapter 2
     * Task 1
     * Calendar
     */
    public static void task11() {
        int year = 2018;
        int month = 11;
        int day = 1;
        LocalDate date = LocalDate.of(year, month, 1);

        System.out.printf("%2s %2s %2s %2s %2s %2s %2s %n", "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa");

        while (date.getMonthValue() == month) {
            int value = date.getDayOfWeek().getValue();

            if (date.getDayOfMonth() == 1) {
                for (int i = 0; i < value; i++) {
                    System.out.printf("%2s ", "");
                }
            }

            System.out.printf("%2d ", date.getDayOfMonth());

            if (value == 6) {
                System.out.println();
            }

            date = date.plusDays(1);
        }
    }
}
