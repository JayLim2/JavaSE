package com.jaylim.ch10.task03;

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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = find("D:\\testDir", "aba");
        ExecutorService service = Executors.newCachedThreadPool();
        int k = 0;
        for (Task task : tasks) {
            System.out.println(task);
            service.submit(task);
            if(k++ == 0) {
                service.shutdownNow();
                return;
            }
        }
    }

    private static List<Task> find(String rootPathName, String word) {
        ArrayList<Task> list = new ArrayList<>();
        Path path = Paths.get(rootPathName);
        try(Stream<Path> pathStream = Files.walk(path, 1)) {
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

    private static class Task implements Runnable {
        private Path path;
        private String word;
        //private int id;

        public Task(String pathName, String word) {
            path = Paths.get(pathName);
            this.word = word;
            //this.id = new Random().nextInt(100);
        }

        @Override
        public void run() {
            try(Stream<Path> pathStream = Files.walk(path, 0)) {
                pathStream.forEach(new Consumer<Path>() {
                    @Override
                    public void accept(Path path) {
                        File file = path.toFile();
                        //System.out.println(id + " path: " + path.toString());
                        if(file.isFile()) {
                            try(Scanner scanner = new Scanner(new FileReader(file))) {
                                while (scanner.hasNext()) {
                                    if(Thread.currentThread().isInterrupted()) {
                                        System.out.println("Task is interrupted.");
                                        return;
                                    }

                                    String next = scanner.next();
                                    //System.out.println("currentWord: " + next);
                                    if(next.equals(word)) {
                                        System.out.println("Word is found.");
                                        //System.out.println(next + " " + word);
                                        return;
                                    }
                                }
                            } catch (FileNotFoundException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }
                });
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public String toString() {
            return word + " " + path.toString();
        }
    }
}
