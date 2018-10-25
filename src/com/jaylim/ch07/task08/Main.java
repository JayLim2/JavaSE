package com.jaylim.ch07.task08;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Main {
    // FIXME: 10/25/2018 UNOPTIMIZED SOLUTION
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader(new File("words.txt"));
        Scanner scanner = new Scanner(fileReader);
        Map<String, Map<String, Integer>> wordMap = new TreeMap<>();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] words = s.split(" ");
            Map<String, Integer> wordsInLine = new TreeMap<>();
            for (String word : words) {
                if (!wordsInLine.containsKey(word)) {
                    wordsInLine.put(word, 1);
                } else {
                    wordsInLine.put(word, wordsInLine.get(word) + 1);
                }
            }
            wordMap.put(s, wordsInLine);
        }

        for (Map.Entry<String, Map<String, Integer>> entry : wordMap.entrySet()) {
            System.out.println(entry);
        }
    }
}
