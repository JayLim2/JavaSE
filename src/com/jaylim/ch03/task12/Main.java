package com.jaylim.ch03.task12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

// FIXME: 10/23/2018 UNRESOLVED
public class Main {
    public static void main(String[] args) throws IOException {
        List<String> pathNames = new ArrayList<>();
        pathNames.add("C:\\Users\\seko0918\\testFolder\\temp");
        pathNames.add("C:\\Users\\seko0918\\testFolder\\bba11.txt");
        pathNames.add("C:\\Users\\seko0918\\testFolder\\abac1.txt");
        pathNames.add("C:\\Users\\seko0918\\testFolder\\temp\\aba.txt");
        pathNames.add("C:\\Users\\seko0918\\testFolder\\temp\\bbb.txt");
        pathNames.add("C:\\Users\\seko0918\\testFolder");
        pathNames.add("C:\\Users\\seko0918\\normalFolder");
        pathNames.add("C:\\Users\\seko0918\\normalFolder\\temp2");

        /*Files.createDirectories(Paths.get(pathNames.get(0)));
        Files.createFile(Paths.get(pathNames.get(1)));
        Files.createFile(Paths.get(pathNames.get(2)));
        Files.createFile(Paths.get(pathNames.get(3)));
        Files.createFile(Paths.get(pathNames.get(4)));
        Files.createDirectory(Paths.get(pathNames.get(6)));
        Files.createDirectory(Paths.get(pathNames.get(7)));*/

        File[] files = getFilesListByFilenames(pathNames.toArray(new String[]{}));
        sortFileList(files);

        for (File file : files) {
            System.out.println(file.getPath());
        }

        /*
        result:

        C:\Users\seko0918\normalFolder
        C:\Users\seko0918\normalFolder\temp2
        C:\Users\seko0918\testFolder
        C:\Users\seko0918\testFolder\temp
        C:\Users\seko0918\testFolder\abac1.txt
        C:\Users\seko0918\testFolder\bba11.txt
        C:\Users\seko0918\testFolder\temp\aba.txt
        C:\Users\seko0918\testFolder\temp\bbb.txt
         */
    }

    public static File[] getFilesListByFilenames(String... filenames) throws IOException {
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
                //System.out.println(objectOneIsFile + " " + o1.getPath());

                //Если о1 папка, а о2 - файл
                if (!objectOneIsFile && objectTwoIsFile) {
                    result = -1;
                } else if (objectOneIsFile && !objectTwoIsFile) {
                    //Если о1 файл, а о2 - папка
                    result = 1;
                } else {//Если оба файлы или оба папки
                    result = o1.compareTo(o2);
                }

                return result;
            }
        };
        Arrays.sort(files, cmp);
    }
}
