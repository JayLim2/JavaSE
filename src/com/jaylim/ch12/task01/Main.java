package com.jaylim.ch12.task01;

import java.time.LocalDate;
import java.time.Year;

public class Main {
    public static void main(String[] args) {
        LocalDate progerDay = LocalDate.ofYearDay(Year.now().getValue(), 256);
        System.out.println(progerDay);
    }
}
