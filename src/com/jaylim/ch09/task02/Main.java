package com.jaylim.ch09.task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(
                new File("input1.txt").toPath(),
                Charset.forName("UTF-8")
        )) {
            Map<String, List<Integer>> map = new HashMap<>();
            int numLine = 1;
            while (reader.ready()) {
                String[] words = reader.readLine().split("\\s+");
                for (String word : words) {
                    map.putIfAbsent(word, map.getOrDefault(word, new ArrayList<>()));
                    map.get(word).add(numLine);
                }
                numLine++;
            }

            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                System.out.println(entry);
            }
        } catch (IOException ex) {

        }
    }
}
