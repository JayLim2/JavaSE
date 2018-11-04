package com.jaylim.ch12.task10;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) {
        final String LA = "America/Los_Angeles";
        final String FM = "Europe/Berlin";
        Duration duration = Duration.ofHours(10).plusMinutes(50);
        ZonedDateTime example = convert(LocalDateTime.now(), duration, LA, FM);
        System.out.println(defaultZonedFormat(example));
    }

    public static ZonedDateTime convert(LocalDateTime start, Duration duration, String firstZone, String secondZone) {
        ZonedDateTime dateTime1 = ZonedDateTime.of(start, ZoneId.of(firstZone));
        return dateTime1.plusMinutes(duration.toMinutes()).withZoneSameInstant(ZoneId.of(secondZone));
    }

    public static String defaultZonedFormat(ZonedDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
    }

    public static String defaultLocalFormat(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL));
    }
}
