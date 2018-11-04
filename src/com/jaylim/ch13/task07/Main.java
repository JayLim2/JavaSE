package com.jaylim.ch13.task07;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Month[] months = Month.values();
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            List<String> display = new ArrayList<>();
            List<String> standalone = new ArrayList<>();
            boolean flag = true;
            for (Month month : months) {
                String displayName = month.getDisplayName(TextStyle.FULL, locale);
                String standaloneName = month.getDisplayName(TextStyle.FULL_STANDALONE, locale);
                display.add(displayName);
                standalone.add(standaloneName);
                flag &= displayName.equals(standaloneName);
                if (!flag) break;
            }
            if (flag) {
                System.out.println(locale + "");
                for (int i = 0; i < display.size(); i++) {
                    System.out.printf("%15s %15s %n", display.get(i), standalone.get(i));
                }
                System.out.println();
            }
        }
    }
}
