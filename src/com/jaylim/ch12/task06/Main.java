package com.jaylim.ch12.task06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(1900, 1, 13);
        List<LocalDate> friday13 = new ArrayList<>();
        while (date.getYear() < 2000) {
            int nextYear = date.plusYears(1).getYear();
            while (date.getYear() < nextYear) {
                if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                    friday13.add(date);
                }
                date = date.plusMonths(1);
            }
            date = date.plusYears(1);
        }
        for (LocalDate localDate : friday13) {
            System.out.println(localDate);
        }
    }
}
