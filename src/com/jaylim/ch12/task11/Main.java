package com.jaylim.ch12.task11;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) {
        final String LA = "America/Los_Angeles";
        final String FM = "Europe/Berlin";
        LocalDateTime localDateTime1 = LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 5));
        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 40));
        Duration duration = convert(localDateTime1, localDateTime2, FM, LA);
        System.out.println((double) duration.toMinutes() / 60);
    }

    public static Duration convert(LocalDateTime start, LocalDateTime end, String firstZone, String secondZone) {
        ZonedDateTime dateTime1 = ZonedDateTime.of(start, ZoneId.of(firstZone));
        ZonedDateTime dateTime2 = ZonedDateTime.of(end, ZoneId.of(secondZone));
        return Duration.between(dateTime1, dateTime2);
    }

    public static String defaultZonedFormat(ZonedDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
    }

    public static String defaultLocalFormat(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
    }
}
