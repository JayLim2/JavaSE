package com.jaylim.ch08.task01;


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
        stream.filter((s) -> {
            boolean res = s.length() >= 10;
            if (res) {
                System.out.println("filtering: " + s);
            }
            return res;
        }).limit(5).forEach((s) -> System.out.print(""));
    }
}
