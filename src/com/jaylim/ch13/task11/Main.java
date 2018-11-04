package com.jaylim.ch13.task11;

import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        List<PaperFormat> usFormats = PaperFormat.getAvailableFormats(Locale.US);
        List<PaperFormat> canadaFrenchFormats = PaperFormat.getAvailableFormats(Locale.CANADA_FRENCH);
        List<PaperFormat> ruFormats = PaperFormat.getAvailableFormats(Locale.getDefault());

        for (PaperFormat ruFormat : ruFormats) {
            System.out.println(ruFormat);
        }
        System.out.println();
        for (PaperFormat usFormat : usFormats) {
            System.out.println(usFormat);
        }
        System.out.println();
        for (PaperFormat frenchFormat : canadaFrenchFormats) {
            System.out.println(frenchFormat);
        }
    }
}
