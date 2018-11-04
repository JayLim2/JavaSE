package com.jaylim.ch12.task04;

import java.time.LocalDate;
import java.util.IllegalFormatException;

public class Cal {
    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                int month = Integer.parseInt(args[0]);
                int year = Integer.parseInt(args[1]);

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
            } catch (IllegalFormatException ex) {

            }
        }
    }
}
