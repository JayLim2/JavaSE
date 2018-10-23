package com.jaylim.ch03.task12;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        File[] files = getFilesListByFilenames("D:\\",
                "D:\\temp",
                "bba11.txt",
                "abac1.txt",
                "D:\\temp\\aba.txt",
                "D:\\temp\\bbb.txt");
        sortFileList(files);
        for (File file : files) {
            System.out.println(file.getPath());
        }
    }

    public static File[] getFilesListByFilenames(String... filenames) {
        File[] files = new File[filenames.length];
        for (int i = 0; i < filenames.length; i++) {
            files[i] = new File(filenames[i]);
        }
        return files;
    }

    public static void sortFileList(File... files) {
        Comparator<File> cmp = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int result = 0;

                boolean objectOneIsFile = o1.isFile();
                boolean objectTwoIsFile = o2.isFile();
                boolean objectOneIsDir = o1.isDirectory();
                boolean objectTwoIsDir = o2.isDirectory();

                //Если о1 папка, а о2 - файл
                if (objectOneIsDir && objectTwoIsFile) {
                    System.out.println("case 1");
                    result = 1;
                } else if (objectOneIsFile && objectTwoIsDir) {
                    System.out.println("case 2");
                    //Если о1 файл, а о2 - папка
                    result = -1;
                } else //Если оба файлы или оба папки
                    if ((objectOneIsFile && objectTwoIsFile) ||
                            (objectOneIsDir && objectTwoIsDir)) {
                        System.out.println("case 3");
                        result = o1.compareTo(o2);
                    }

                return result;
            }
        };

        Arrays.sort(files, cmp);
    }
}
