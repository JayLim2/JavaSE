package com.jaylim.ch10.task12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main12 {
    public static Map<String, Integer> counts = new HashMap<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FileWalker walker = new FileWalker("C:\\Users\\seko0918\\testFolder\\q");

        ExecutorService service = Executors.newCachedThreadPool();

        //Merging results
        List<Future<Map<String, Integer>>> futures = service.invokeAll(walker.getTasks());
        for (Future<Map<String, Integer>> future : futures) {
            Map<String, Integer> map = future.get();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                counts.merge(entry.getKey(), entry.getValue(), Integer::sum);
            }
        }
        service.shutdown();

        //Print summary map
        while (!service.isTerminated()) ;

        counts.entrySet().stream().sorted(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        }).limit(10).forEachOrdered(System.out::println);

        /*
        ConcurrentHashMap не потребуется, т.к. нет разделяемых данных,
        т.е. подсчет производится в каждом отдельном файле.
         */
    }

    private static class FileWalker {
        private Path path;

        public FileWalker(String pathName) {
            this.path = Paths.get(pathName);
        }

        public List<Callable<Map<String, Integer>>> getTasks() {
            List<Callable<Map<String, Integer>>> tasks = new ArrayList<>();
            try (Stream<Path> pathStream = Files.walk(path)) {
                pathStream.forEach(new Consumer<Path>() {
                    @Override
                    public void accept(Path path) {
                        if (Thread.currentThread().isInterrupted()) {
                            return;
                        }
                        File file = path.toFile();
                        if (file.isFile()) {
                            tasks.add(new FileHandler(file));
                        }
                    }
                });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return tasks;
        }
    }

    private static class FileHandler implements Callable<Map<String, Integer>> {
        private File file;
        private static final File END = new File("END_QUE");

        private Map<String, Integer> countsLocal;

        public FileHandler(File file) {
            this.file = file;
            countsLocal = new HashMap<>();
        }

        @Override
        public Map<String, Integer> call() {
            countWords(file);
            return countsLocal;
        }

        private void countWords(File file) {
            try (Scanner scanner = new Scanner(Files.newBufferedReader(file.toPath()))) {
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    countsLocal.merge(word, 1, Integer::sum);
                }
            } catch (IOException e) {
                System.out.println("Cannot read file.");
            }
        }
    }
}
