package com.jaylim;

import org.omg.CORBA.IntHolder;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        /*com.jaylim.Point point = new com.jaylim.Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println(point.getX());
        System.out.println(point.getY());*/

        /*task1();
        System.out.println();
        System.out.println();
        task11();

        System.out.println("\n");

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
        System.out.println(a1 + " " + b1);*/

        task15();
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

    /**
     * Chapter 2
     * Task 15
     */
    public static void task15() {
        Invoice invoice = new Invoice();

        invoice.addItem("test 1", 10, 1050);
        invoice.addItem("sfddfdsaf 2", 2, 733);
        invoice.addItem("fgfsd 3", 1, 211);
        invoice.addItem("egjfsgk", 5, 54);

        invoice.printInvoice();
    }


}
