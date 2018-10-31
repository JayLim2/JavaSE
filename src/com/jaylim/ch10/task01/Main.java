package com.jaylim.ch10.task01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        //fixme unresolved "Как найти только первый файл?"
        List<Path> files = getFilesByWord("D:\\testDir", "aba");
        for (Path file : files) {
            System.out.println(file.toString());
        }
    }

    public static List<Path> getFilesByWord(String pathName, String word) throws IOException {
        Path path = Paths.get(pathName);
        ArrayList<Path> files = new ArrayList<>();
        try (Stream<Path> pathStream = Files.walk(path).parallel()) {
            pathStream.forEach(new Consumer<Path>() {
                @Override
                public void accept(Path path) {
                    File file = path.toFile();
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(new FileReader(file))) {
                            while (scanner.hasNext()) {
                                if (scanner.next().equals(word)) {
                                    files.add(path);
                                    return;
                                }
                            }
                        } catch (FileNotFoundException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            });
        }
        return files;
    }
}
