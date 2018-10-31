package com.jaylim.ch09.task08;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.Collections;
import java.util.Random;
import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        zip("_test.zip", "_testDir");
    }

    public static void zip(String zipname, String catalogAdr) throws Exception {
        Path catalog = Paths.get(catalogAdr);
        Path zipPath = Paths.get(zipname);
        URI uri = new URI("jar", zipPath.toUri().toString(), null);
        try (FileSystem zipfs = FileSystems.newFileSystem(uri,
                Collections.singletonMap("create", "true"));
             Stream<Path> pathStream = Files.walk(catalog)) {
            pathStream.forEach(new Consumer<Path>() {
                @Override
                public void accept(Path path) {
                    try {
                        Files.copy(path, zipfs.getPath("/").resolve(path.toString()));
                    } catch (IOException e) {
                        e.printStackTrace();
                        Logger.getGlobal().warning("Error with copying to ZIP.");
                    }
                }
            });
        }
    }
}
