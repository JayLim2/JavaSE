package com.jaylim.ch07.task09;

import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader(new File("words.txt"));
        Scanner scanner = new Scanner(fileReader);
        Map<String, Integer> wordMap = new TreeMap<>();

        //Task 9.0
        /*while (scanner.hasNext()) {
            String word = scanner.next();
            wordMap.merge(word, 1, Integer::sum);
        }*/

        //contains
        //resolved in task 7

        //getOrDefault
        /*while (scanner.hasNext()) {
            String word = scanner.next();
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }*/

        //putIfAbsent
        /*while (scanner.hasNext()) {
            String word = scanner.next();

            // FIXME: 10/25/2018 unresolved
        }*/

        for (Map.Entry<String, Integer> stringIntegerEntry : wordMap.entrySet()) {
            System.out.println(stringIntegerEntry);
        }
    }
}
