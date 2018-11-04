package com.jaylim.ch13.task06;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Currency> currencies = Currency.getAvailableCurrencies();
        Locale[] locales = Locale.getAvailableLocales();
        /*for (Currency currency : currencies) {
            System.out.printf("%35s %8s %n", currency.getDisplayName(), moreOneDifferencSymbols(currency, locales));
        }*/
        for (Currency currency : currencies) {
            if (moreOneDifferencSymbols(currency, locales)) {
                System.out.printf("%5d %5s %35s %n", currency.getNumericCode(), currency.getSymbol(), currency.getDisplayName());
            }
        }
    }

    public static boolean moreOneDifferencSymbols(Currency currency, Locale[] locales) {
        String symbol = currency.getSymbol();
        for (Locale locale : locales) {
            if (!Locale.getDefault().equals(locale) && !currency.getSymbol(locale).equals(symbol)) {
                return true;
            }
        }
        return false;
    }
}
