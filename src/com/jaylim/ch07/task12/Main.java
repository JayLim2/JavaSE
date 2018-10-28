package com.jaylim.ch07.task12;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.hasNextLine() ? scanner.nextLine() : null;
        if(line != null) {
            List<String> words = Arrays.asList(line.split(" "));
            words.set(0, words.get(0) != null ? words.get(0).toLowerCase() : null);
            words.set(words.size() - 1, replaceEndDot(words.get(words.size() - 1)));
            if(words.size() > 1) {
                Collections.shuffle(words.subList(1, words.size()-1));
            }
            for (String word : words) {
                System.out.print(word + " ");
            }
        }
    }

    private static String replaceEndDot(String word) {
        if (word != null) {
            if (word.equals(".")) {
                return "";
            }
            if (word.length() > 1 && word.endsWith(".")) {
                return word.substring(0, word.length() - 1);
            }
        }
        return null;
    }
}
