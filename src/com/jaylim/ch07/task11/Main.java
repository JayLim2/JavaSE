package com.jaylim.ch07.task11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.hasNextLine() ? scanner.nextLine() : null;
        if (line != null) {
            List<String> words = Arrays.asList(line.split(" "));
            if (words.size() > 1) {
                Collections.shuffle(words.subList(1, words.size() - 1));
            }
            for (String word : words) {
                System.out.print(word + " ");
            }
        }
    }
}
