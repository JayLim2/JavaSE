package com.jaylim.ch13.task11;

import com.sun.javafx.binding.StringFormatter;

import java.util.*;

public class PaperFormat {
    private static Map<Locale, List<PaperFormat>> formats;

    static {
        formats = new HashMap<>();

        List<PaperFormat> noUS = new ArrayList<>();
        List<PaperFormat> US_CANADA = new ArrayList<>();
        List<PaperFormat> CANADA_FRENCH = new ArrayList<>();
        formats.put(null, noUS);
        formats.put(Locale.US, US_CANADA);
        formats.put(Locale.CANADA, US_CANADA);
        formats.put(Locale.CANADA_FRENCH, CANADA_FRENCH);

        //filling formats

        //without series B and C
        noUS.add(new PaperFormat("A0", 841, 1189));
        noUS.add(new PaperFormat("A1", 594, 841));
        noUS.add(new PaperFormat("A2", 420, 594));
        noUS.add(new PaperFormat("A3", 297, 420));
        noUS.add(new PaperFormat("A4", 210, 297));
        noUS.add(new PaperFormat("A5", 148, 210));
        noUS.add(new PaperFormat("A6", 105, 148));
        noUS.add(new PaperFormat("A7", 74, 105));
        noUS.add(new PaperFormat("A8", 52, 74));
        noUS.add(new PaperFormat("A9", 37, 52));
        noUS.add(new PaperFormat("A10", 26, 37));

        //without series B and C
        US_CANADA.add(new PaperFormat("Half Letter", 140, 216));
        US_CANADA.add(new PaperFormat("Letter", 216, 279));
        US_CANADA.add(new PaperFormat("Legal", 216, 356));
        US_CANADA.add(new PaperFormat("Junior Legal", 127, 203));
        US_CANADA.add(new PaperFormat("Ledger / Tabloid", 279, 432));

        CANADA_FRENCH.add(new PaperFormat("Demi lettre", 140, 216));
        CANADA_FRENCH.add(new PaperFormat("Lettre", 216, 279));
        CANADA_FRENCH.add(new PaperFormat("Légal", 216, 356));
        CANADA_FRENCH.add(new PaperFormat("Junior Juridique", 127, 203));
        CANADA_FRENCH.add(new PaperFormat("Grand livre / Tabloïde", 279, 432));
    }

    public static List<PaperFormat> getAvailableFormats(Locale locale) {
        List<PaperFormat> list = null;
        if (locale.equals(Locale.US) || locale.equals(Locale.CANADA) || locale.equals(Locale.CANADA_FRENCH)) {
            list = formats.get(locale);
        } else {
            list = formats.get(null);
        }
        return Collections.unmodifiableList(list);
    }

    private String name;
    private int widthMm;
    private int heightMm;

    private PaperFormat(String name, int widthMm, int heightMm) {
        this.name = name;
        this.widthMm = widthMm;
        this.heightMm = heightMm;
    }

    public String getName() {
        return name;
    }

    public int getWidthMm() {
        return widthMm;
    }

    public int getHeightMm() {
        return heightMm;
    }

    @Override
    public String toString() {
        return StringFormatter.format("%25s %4d %3s %5d mm", name, widthMm, "x", heightMm).getValue();
    }
}
