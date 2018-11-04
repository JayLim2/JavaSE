package com.jaylim.ch13.task05;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Locale[] locales = Locale.getAvailableLocales();
        Set<Currency> currencies = Currency.getAvailableCurrencies();

        for (Locale locale : locales) {
            StringBuilder builder = new StringBuilder();
            for (Currency c : currencies) {
                builder.append(c.getSymbol(locale)).append(" ");
                builder.append(c.getDisplayName(locale)).append(";\n");
            }
            System.out.println(builder.toString());
        }
    }
}