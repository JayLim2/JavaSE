package com.jaylim.ch12.task05;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate birthDay = LocalDate.of(1998, 2, 18);
        System.out.println(birthDay.until(LocalDate.now(), ChronoUnit.DAYS));

    }
}
