package com.jaylim.ch09.task11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = getPaths("/folder1/folder2/file.txt");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> getPaths(String pathname) {
        String[] paths = pathname.split("/");
        ArrayList<String> strings = new ArrayList<>();
        if (paths.length > 0) {
            String probableFilename = paths[paths.length - 1];
            if (probableFilename.matches(".*(\\.).*")) {
                System.out.println("file: " + probableFilename);
                System.out.println("filename: " + probableFilename.substring(0, probableFilename.indexOf(".")));
                System.out.println("extension: " + probableFilename.substring(probableFilename.indexOf(".")));
            }
        }
        return Arrays.asList(paths);
    }
}
