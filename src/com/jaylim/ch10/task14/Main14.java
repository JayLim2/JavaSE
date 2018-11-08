package com.jaylim.ch10.task14;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main14 {
    public static ConcurrentHashMap<String, Integer> counts = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FileWalker walker = new FileWalker("C:\\Users\\seko0918\\testFolder\\q");

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(walker);
        service.shutdown();

        //Print summary map
        while (!service.isTerminated()) ;

        counts.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        }).limit(10).forEachOrdered(System.out::println);
    }

    private static class FileWalker implements Runnable {
        private Path path;

        public FileWalker(String pathName) {
            this.path = Paths.get(pathName);
        }

        public void run() {
            try (Stream<Path> pathStream = Files.walk(path)) {
                pathStream.forEach(new Consumer<Path>() {
                    @Override
                    public void accept(Path path) {
                        if (Thread.currentThread().isInterrupted()) {
                            return;
                        }
                        File file = path.toFile();
                        if (file.isFile()) {
                            countWords(file);
                        }
                    }
                });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        private void countWords(File file) {
            try (Scanner scanner = new Scanner(Files.newBufferedReader(file.toPath()))) {
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    counts.merge(word, 1, Integer::sum);
                }
            } catch (IOException e) {
                System.out.println("Cannot read file.");
            }
        }
    }
}
