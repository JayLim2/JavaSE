package com.jaylim.ch10.task05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

public class Main {
    private static ConcurrentHashMap<String, Set<File>> allWords = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Runnable task1 = new Finder(allWords, new File("file1.txt"),
                new File("file2.txt"));
        Runnable task2 = new Finder(allWords, new File("file3.txt"),
                new File("file4.txt"));

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(task1);
        service.submit(task2);
        service.shutdown();

        while (!service.isTerminated()) ;
        for (Map.Entry<String, Set<File>> entry : allWords.entrySet()) {
            System.out.println(entry);
        }
    }

    private static class Finder implements Runnable {
        private List<File> files;
        private ConcurrentHashMap<String, Set<File>> words;

        public Finder(ConcurrentHashMap<String, Set<File>> map, File... files) {
            this.files = Arrays.asList(files);
            words = map;
        }

        public Finder(ConcurrentHashMap<String, Set<File>> map, List<File> files) {
            this.files = files;
            words = map;
        }

        @Override
        public void run() {
            for (File file : files) {
                if (file.isFile()) {
                    Path path = file.toPath();
                    try (Scanner scanner = new Scanner(Files.newBufferedReader(path))) {
                        while (scanner.hasNext()) {
                            String word = scanner.next();
                            System.out.println(path.toString() + " " + word);
                            Set<File> set = new HashSet<>();
                            set.add(file);
                            words.merge(word, set, new BiFunction<Set<File>, Set<File>, Set<File>>() {
                                @Override
                                public Set<File> apply(Set<File> files, Set<File> files2) {
                                    files.add(file);
                                    files2.addAll(files);
                                    return files2;
                                }
                            });
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            System.out.println("End of task.");
        }
    }
}
