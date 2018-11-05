package com.jaylim.ch08.task07;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        //Вывести все слова
        Stream<String> stream = getWordsStream("task06.txt");
        stream.forEach(System.out::println);

        System.out.println();

        //Подсчитать частоту. Вывести 10 наиболее частых.
        Stream<String> stream2 = getWordsStream("task06.txt");
        List<String> words = stream2.collect(Collectors.toList());
        Map<String, Integer> mapWordsToCount = new TreeMap<>();
        words.forEach((word) -> mapWordsToCount.merge(word, 1, Integer::sum));
        for (Map.Entry<String, Integer> e : mapWordsToCount.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer count1 = mapWordsToCount.get(o1);
                Integer count2 = mapWordsToCount.get(o2);
                if (count1 == null) count1 = 0;
                if (count2 == null) count2 = 0;
                return -Integer.compare(count1, count2);
            }
        });

        System.out.println();
        Set<String> set = new HashSet<>();
        for (String s : words) {
            if (set.size() == 10) break;
            if (!set.contains(s)) {
                System.out.println(s);
                set.add(s);
            }
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
                return s.toLowerCase().codePoints().allMatch(Character::isAlphabetic);
            }
        });
        return stream;
    }
}
