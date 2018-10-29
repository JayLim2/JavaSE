package com.jaylim.ch08.task02;

import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        Set<String> words = new HashSet<>();
        Scanner scanner = new Scanner(new FileReader(new File("exampleText.txt")));
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }

        Stream<String> stream = words.stream();
        Stream<String> parallelStram = words.parallelStream();

        long time1 = System.currentTimeMillis();
        long count1 = stream.filter((s) -> s.length() >= 10).count();
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        long count2 = parallelStram.filter((s) -> s.length() >= 10).count();
        long time3 = System.currentTimeMillis();
        System.out.println(time3 - time2);
    }
}
