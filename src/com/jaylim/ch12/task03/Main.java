package com.jaylim.ch12.task03;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.of(2018, 11, 8);
        System.out.println(now);
        //now = now.with(next(w -> w.getDayOfWeek().getValue() < 6));
        now = now.with(next(w -> w.getMonth().getValue() == 12 && w.getYear() == 2024));
        System.out.println(now);
    }

    /*
    Возвращает корректор дат, который позволяет вычислить следующую дату,
    удовлетворяющую переданному предикату
     */
    public static TemporalAdjuster next(Predicate<LocalDate> datePredicate) {
        TemporalAdjuster adjuster = new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                LocalDate localDate = ((LocalDate) temporal).plusDays(1);
                while (!datePredicate.test(localDate)) {
                    localDate = localDate.plusDays(1);
                }
                return localDate;
            }
        };
        return adjuster;
    }
}
