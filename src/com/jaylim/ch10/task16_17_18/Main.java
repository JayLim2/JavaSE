package com.jaylim.ch10.task16_17_18;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static long count = 0;

    public static void main(String[] args) throws InterruptedException {
        walk("D:\\testDir");
        Thread.sleep(2000);
        System.out.println(count);
        /*
        Внезапно, счетчик в итоге имеет всегда разные значения.
        Т.к. переменная не volatile, а изменение - неатомарно,
        происходит увеличение на 1 уже устаревшего значение,
        поэтому новое значение неверно.
         */
    }

    public static void walk(String pathName) {
        Path path = Paths.get(pathName);
        try (Stream<Path> pathStream = Files.walk(path)) {
            pathStream.forEach(new Consumer<Path>() {
                @Override
                public void accept(Path path) {
                    new Thread(new WalkTask(path)).start();
                }
            });
        } catch (IOException e) {
            System.out.println("root: " + e.getMessage());
        }
    }

    private static class WalkTask implements Runnable {
        private Path path;

        public WalkTask(Path path) {
            this.path = path;
        }

        public Path getPath() {
            return path;
        }

        public void setPath(Path path) {
            this.path = path;
        }

        @Override
        public void run() {
            try {
                File file = path.toFile();
                if (file.isFile()) {
                    Scanner scanner = new Scanner(Files.newBufferedReader(path));
                    while (scanner.hasNext()) {
                        scanner.next();
                        count++;
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
