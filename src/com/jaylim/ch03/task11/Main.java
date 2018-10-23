package com.jaylim.ch03.task11;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String[] strings = getAllFilesInDir(new File("C:\\"), ".txt");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * Chapter 3
     * Task 11 (solve #1)
     *
     * @param dir
     * @param ext
     * @return
     */
    public static String[] getAllFilesInDir(File dir, String ext) {
        return dir.list((directory, fname) -> fname.endsWith(ext));
    }
}
