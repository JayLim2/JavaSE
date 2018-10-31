package com.jaylim.ch10.task16_17_18;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main2 {
    public static long count = 0;
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        walk("D:\\testDir");
        Thread.sleep(2000);
        System.out.println(count);
        /*
        В данном примере применена синхронизация операции count++
        Она является неатомарной, поэтому во время присваивания поток
        может быть вытеснен другим, а другой поток изменит значение,
        в итоге, когда данный поток будет возобновлен (это может быть
        совсем не обязательно сразу после второго потока), он присвоит
        некорректное значение.
        Синхронизация делает операцию атомарной. Пока она выполняется,
        остальные потоки будут ждать.

        При нескольких прогонах данной программы возвращается один и тот
        же результат.
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
                        synchronized (lock) {
                            count++;
                        }
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
