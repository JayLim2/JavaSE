package com.jaylim.ch13.task03;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        /*
        es_PA
        es_PR
        en_US
        es_SV
        es_US
        en
        es_HN
        hi
        es_NI
         */
        ZonedDateTime dateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            System.out.printf("%25s %30s %n", locale, formatDateTimeByLocale(dateTime, locale));
        }
    }

    public static String formatDateTimeByLocale(ZonedDateTime dateTime, Locale locale) {
        return dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(locale));
    }
}
