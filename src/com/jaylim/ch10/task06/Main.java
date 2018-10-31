package com.jaylim.ch10.task06;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    private static ConcurrentHashMap<String, Set<File>> allWords = new ConcurrentHashMap<>();

    public static void main(String[] args) {
         /*
            Преимущество применения computeIfAbsent в том, что
            при операции Merge мы должны сразу передавать инициализирующее
            значение.
            В случае с коллекциями это даже в этом примере не очень удобно,
            поскольку операция добавления не возвращает коллекцию, а лишь
            признак успешности операции.
            С помощью методов ifAbsent + ifPresent мы можем инициализировать
            гораздо более сложно, чем в данном примере, что может быть полезно,
            если необходимо как то выделить логику инициализации из общего
            кода.
            Если же значения являются примитивными, то такой подход скорее всего
            будет нецелесообразен, хотя инициализация так же может быть результатом
            череды вычислений.
         */

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
                    Set<File> set = new HashSet<>();
                    try (Scanner scanner = new Scanner(Files.newBufferedReader(path))) {
                        while (scanner.hasNext()) {
                            String word = scanner.next();
                            System.out.println(path.toString() + " " + word);
                            words.computeIfAbsent(word, new Function<String, Set<File>>() {
                                @Override
                                public Set<File> apply(String s) {
                                    Set<File> setFiles = new HashSet<>();
                                    setFiles.add(file);
                                    return setFiles;
                                }
                            });
                            words.computeIfPresent(word, new BiFunction<String, Set<File>, Set<File>>() {
                                @Override
                                public Set<File> apply(String s, Set<File> files) {
                                    files.add(file);
                                    return files;
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
