package com.jaylim.ch13.task10;

import sun.nio.cs.CharsetMapping;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

// FIXME: 04.11.2018 UNRESOLVED (??????????)
public class Main {
    private static final SortedMap<String, Charset> map = Charset.availableCharsets();

    public static void main(String[] args) {
        Locale[] locales = Locale.getAvailableLocales();
        SortedMap<String, Charset> localMap = new TreeMap<>();
        for (Locale locale : locales) {
            localMap.putAll(getLocalizedCharsets(locale));
        }

        for (Map.Entry<String, Charset> entry : localMap.entrySet()) {
            System.out.println(entry);
        }
    }

    public static SortedMap<String, Charset> getLocalizedCharsets(Locale locale) {
        SortedMap<String, Charset> newMap = new TreeMap<>();
        for (Map.Entry<String, Charset> entry : map.entrySet()) {
            Charset charset = entry.getValue();
            newMap.put(charset.displayName(locale), charset);
        }
        return newMap;
    }
}
