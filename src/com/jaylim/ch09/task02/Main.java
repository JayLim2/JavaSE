package com.jaylim.ch09.task02;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("input1.txt"),
                Charset.forName("UTF-8"));
             PrintWriter fileWriter = new PrintWriter(Files.newBufferedWriter(
                     Paths.get("output1.toc"),
                     Charset.forName("UTF-8")))
        ) {
            Map<String, List<Integer>> map = new HashMap<>();
            int numLine = 1;
            List<Integer> tmpList;
            while (reader.ready()) {
                String[] words = reader.readLine().split("\\s+");
                for (String word : words) {
                    map.putIfAbsent(word, map.getOrDefault(word, new ArrayList<>()));
                    tmpList = map.get(word);
                    if (tmpList != null) {
                        tmpList.add(numLine);
                    }
                }
                numLine++;
            }

            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                System.out.println(entry);
                fileWriter.println(entry);
            }
        } catch (IOException ex) {

        }
    }
}
