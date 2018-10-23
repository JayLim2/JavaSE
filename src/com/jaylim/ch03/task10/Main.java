package com.jaylim.ch03.task10;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File[] files = getAllSubdirs(new File("C:\\"));

        for (File file : files) {
            System.out.println(file.toString());
        }
    }

    /**
     * Chapter 3
     * Task 10
     *
     * @param dir
     * @return
     */
    public static File[] getAllSubdirs(File dir) {
        return dir.listFiles((path) -> path.isDirectory());
    }

    /**
     * Chapter 3
     * Task 10 (solve #2)
     *
     * @param dir
     * @return
     */
    public static File[] getAllSubdirs2(File dir) {
        return dir.listFiles(File::isDirectory);
    }

}
