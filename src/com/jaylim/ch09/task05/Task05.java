package com.jaylim.ch09.task05;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class Task05 {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (Charset charset : charsets.values()) {
            try {
                byte[] bytes = charset.newEncoder().replacement();
                System.out.printf("%35s %5s %n", charset.displayName(), new String(bytes));
            } catch (Exception e) {
            }
        }
    }
}
