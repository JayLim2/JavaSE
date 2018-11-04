package com.jaylim.ch13.task04;

import java.text.MessageFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale[] locales = Locale.getAvailableLocales();

        for (Locale locale : locales) {
            StringBuilder builder = new StringBuilder();
            for (Locale locale1 : locales) {
                builder.append(locale1.getDisplayCountry(locale)).append(" ");
                builder.append(locale1.getDisplayLanguage(locale)).append(";\n");
            }
            System.out.println(builder.toString());
        }
    }
}
