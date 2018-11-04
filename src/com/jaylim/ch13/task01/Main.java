package com.jaylim.ch13.task01;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ZonedDateTime dateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        System.out.println(formatDateTimeByLocale(dateTime, Locale.CHINA));
        System.out.println(formatDateTimeByLocale(dateTime, Locale.FRANCE));
        System.out.println(formatDateTimeByLocale(dateTime, Locale.forLanguageTag("th-TH")));
    }

    public static String formatDateTimeByLocale(ZonedDateTime dateTime, Locale locale) {
        return dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(locale));
    }
}
