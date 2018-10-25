package com.jaylim.ch07.task07;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader(new File("words.txt"));
        Scanner scanner = new Scanner(fileReader);
        Map<String, Integer> wordMap = new TreeMap<>();
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (!wordMap.containsKey(s)) {
                wordMap.put(s, 1);
            } else {
                wordMap.put(s, wordMap.get(s) + 1);
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : wordMap.entrySet()) {
            System.out.println(stringIntegerEntry);
        }
    }
}
