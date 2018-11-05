package com.jaylim.ch01.task11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input string:");
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char[] chars = line.toCharArray();
                System.out.println("No ASCII chars:");
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] > 255) {
                        System.out.println(chars[i] + " (" + (int) chars[i] + ")");
                    }
                }
            }
        }
    }
}
