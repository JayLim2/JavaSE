package com.jaylim.ch10.task03;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Task> tasks = find("D:\\testDir", "aba");
        if (tasks == null) return;
        ExecutorService service = Executors.newCachedThreadPool();
        for (Task task : tasks) {
            System.out.println(task);
            Future<Boolean> isFound = service.submit(task);
            if (isFound.get()) {
                service.shutdownNow();
                System.out.println("Service shutdowning...");
                return;
            }
        }
        service.shutdown();
    }

    private static List<Task> find(String rootPathName, String word) {
        ArrayList<Task> list = new ArrayList<>();
        Path path = Paths.get(rootPathName);
        try (Stream<Path> pathStream = Files.walk(path, 1)) {
            pathStream.forEach(new Consumer<Path>() {
                @Override
                public void accept(Path path) {
                    list.add(new Task(path.toString(), word));
                }
            });
            return list;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static class Task implements Callable<Boolean> {
        private Path path;
        private String word;
        //private int id;

        public Task(String pathName, String word) {
            path = Paths.get(pathName);
            this.word = word;
            //this.id = new Random().nextInt(100);
        }

        @Override
        public Boolean call() {
            boolean isFound = false;
            try (Stream<Path> pathStream = Files.walk(path, 0)) {
                Stream<Boolean> booleanStream = pathStream.map(new Function<Path, Boolean>() {
                    @Override
                    public Boolean apply(Path path) {
                        File file = path.toFile();
                        //System.out.println(id + " path: " + path.toString());
                        if (file.isFile()) {
                            try (Scanner scanner = new Scanner(new FileReader(file))) {
                                while (scanner.hasNext()) {
                                    if (Thread.currentThread().isInterrupted()) {
                                        System.out.println("Task is interrupted.");
                                        return false;
                                    }

                                    String next = scanner.next();
                                    //System.out.println("currentWord: " + next);
                                    if (next.equals(word)) {
                                        System.out.println("Word is found.");
                                        //System.out.println(next + " " + word);
                                        return true;
                                    }
                                }
                            } catch (FileNotFoundException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                        return false;
                    }
                });
                isFound = booleanStream.anyMatch(aBoolean -> aBoolean);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return isFound;
        }

        @Override
        public String toString() {
            return word + " " + path.toString();
        }
    }
}
