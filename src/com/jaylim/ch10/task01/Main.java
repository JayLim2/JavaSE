package com.jaylim.ch10.task01;

import java.io.File;
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
    public static void main(String[] args) {
        //fixme unresolved
    }

    public static List<Path> getFilesByWord(String pathName, String word) throws IOException {
        Path path = Paths.get(pathName);
        ArrayList<Path> files = new ArrayList<>();
        try(Stream<Path> pathStream = Files.walk(path)) {
            pathStream.forEach(new Consumer<Path>() {
                @Override
                public void accept(Path path) {
                    if(path.toFile().isFile()) {
                        Scanner scanner = new Scanner(System.in);
                        while (scanner.hasNext()) {
                            if(scanner.next().equals(word)) {
                                files.add(path);
                                return;
                            }
                        }
                    }
                }
            });
        }
        return files;
    }
}
