package com.jaylim.ch10.task10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static BlockingQueue<File> files = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        FileWalker walker = new FileWalker("C:\\Users\\seko0918\\testFolder\\q", files);
        FileHandler handler1 = new FileHandler(files, "aba");
        FileHandler handler2 = new FileHandler(files, "aba");
        FileHandler handler3 = new FileHandler(files, "aba");

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(walker);
        service.submit(handler1);
        service.submit(handler2);
        service.submit(handler3);
        service.shutdown();
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

    private static class FileHandler implements Runnable {
        private BlockingQueue<File> queue;
        private String word;
        private static final File END = new File("END_QUE");

        public FileHandler(BlockingQueue<File> queue, String word) {
            this.queue = queue;
            this.word = word;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    File file = queue.take();
                    if (file.equals(END)) {
                        queue.put(file);
                        System.out.println("END_QUE is found. Terminating thread...");
                        return;
                    }

                    if (containsWord(file)) {
                        System.out.println("Word \"" + word + "\" found in file: " + file.getAbsolutePath());
                    }
                    if (file.delete()) {
                        System.out.println("File " + file.getAbsolutePath() + " is deleted.");
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                    return;
                }
            }
        }

        public boolean containsWord(File file) {
            try (Scanner scanner = new Scanner(Files.newBufferedReader(file.toPath()))) {
                while (scanner.hasNext()) {
                    if (scanner.next().equals(word)) {
                        return true;
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            return false;
        }
    }
}
