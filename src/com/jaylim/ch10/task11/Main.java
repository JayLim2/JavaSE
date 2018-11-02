package com.jaylim.ch10.task11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static BlockingQueue<File> files = new ArrayBlockingQueue<>(5);
    public static Queue<String> wordsQue = new ArrayDeque<>();
    public static Map<String, Integer> counts = new HashMap<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FileWalker walker = new FileWalker("C:\\Users\\seko0918\\testFolder\\q", files);
        ArrayList<FileHandler> handlers = new ArrayList<>();
        handlers.add(new FileHandler(files, wordsQue));
        handlers.add(new FileHandler(files, wordsQue));
        handlers.add(new FileHandler(files, wordsQue));

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(walker);

        //Merging results
        List<Future<Map<String, Integer>>> futures = service.invokeAll(handlers);
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
        ConcurrentHashMap не потребуется, т.к. применяется блокирующая очередь,
        которая не дает доступа к одному и тому же файлу из нескольких потоков.
        Отсюда, коллекции слов не пересекаются и их можно безболезненно объединить.
         */
    }

    private static class FileWalker implements Runnable {
        private Path path;
        private BlockingQueue<File> queue;

        public FileWalker(String pathName, BlockingQueue<File> queue) {
            this.path = Paths.get(pathName);
            this.queue = queue;
        }

        @Override
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
                            try {
                                queue.put(file);
                            } catch (InterruptedException ex) {
                                System.out.println("Thread interrupted.");
                            }
                        }
                    }
                });
                queue.put(new File("END_QUE"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }

    private static class FileHandler implements Callable<Map<String, Integer>> {
        private BlockingQueue<File> queue;
        private static final File END = new File("END_QUE");

        private Queue<String> wordsQue;
        private Map<String, Integer> countsLocal;

        public FileHandler(BlockingQueue<File> filesQue, Queue<String> wordsQue) {
            this.queue = filesQue;
            this.wordsQue = wordsQue;
            countsLocal = new HashMap<>();
        }

        @Override
        public Map<String, Integer> call() {
            while (true) {
                try {
                    File file = queue.take();
                    if (file.equals(END)) {
                        queue.put(file);
                        System.out.println("END_QUE is found. Terminating thread...");
                        return countsLocal;
                    } else {
                        countWords(file);
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
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
