package com.jaylim.ch08.task16;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader(new File("wnp.txt")));
        Set<String> words = new HashSet<>();
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
        Stream<String> stream = words
                .parallelStream()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(500);
        stream.forEachOrdered(System.out::println);
    }
}
