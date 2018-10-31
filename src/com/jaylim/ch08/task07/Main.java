package com.jaylim.ch08.task07;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Stream<String> stream = getWordsStream("task07.txt");
        stream.forEach(System.out::println);

        System.out.println();

        Stream<String> stream2 = getWordsStream("task07.txt");
        Map<String, Integer> mapWordsToCount = new TreeMap<>();
        stream2.forEach((word) -> mapWordsToCount.put(word, mapWordsToCount.getOrDefault(word, 1) + 1));

        for (Map.Entry<String, Integer> e : mapWordsToCount.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    public static Stream<String> getWordsStream(String filename) throws IOException {
        Scanner scanner = new Scanner(new FileReader(new File(filename)));
        Stream<String> stream = Stream.generate(() -> scanner.hasNext() ? scanner.next().toLowerCase() : null);
        stream = stream.limit(100).filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s == null)
                    return false;
                return s.codePoints().allMatch(Character::isAlphabetic);
            }
        });
        return stream;
    }
}
