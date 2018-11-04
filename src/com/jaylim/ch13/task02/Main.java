package com.jaylim.ch13.task02;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        /*
        th_TH_TH_#u-nu-thai
        hi_IN
         */
        Locale[] locales = Locale.getAvailableLocales();

        for (Locale locale : locales) {
            System.out.printf("%30s %10s %n", locale, NumberFormat.getInstance(locale).format(100));
        }
    }
}
