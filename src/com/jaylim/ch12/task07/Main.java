package com.jaylim.ch12.task07;

import com.sun.istack.internal.NotNull;

import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LocalDateTime time1 = LocalDateTime.of(LocalDate.of(2018, 1, 1), LocalTime.of(11, 0));
        TimeInterval.plan(time1, Duration.ofHours(1));
        LocalDateTime time2 = LocalDateTime.of(LocalDate.of(2018, 1, 1), LocalTime.of(11, 30));
        LocalDateTime time3 = LocalDateTime.of(LocalDate.of(2018, 1, 1), LocalTime.of(12, 0));
        LocalDateTime time4 = LocalDateTime.of(LocalDate.of(2018, 1, 1), LocalTime.of(10, 0));
        TimeInterval.plan(time2, Duration.ofHours(1));
        TimeInterval.plan(time3, Duration.ofHours(1));
        TimeInterval.plan(time4, Duration.ofHours(1));
        List<TimeInterval> events = TimeInterval.getEvents();
        for (TimeInterval event : events) {
            System.out.println(event);
        }
    }
}

