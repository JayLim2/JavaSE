package com.jaylim.ch09.task04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        List<String> L1 = getLines1("0904.txt");
        long t2 = System.currentTimeMillis();
        List<String> L2 = getLines2("0904.txt");
        long t3 = System.currentTimeMillis();
        List<String> L3 = getLines3("0904.txt");
        long t4 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        System.out.println(t3 - t2);
        System.out.println(t4 - t3);

        /*
        Наиболее медленно работается BufferedReader.lines()
        Наиболее быстро работает построчная обработка через BufferedReader
        Сканнер работает несколько медленнее BufferedReader, но не значительно,
        но по удобству Scanner значительно превосходит BufferedReader,
        поэтому из данных вариантов является наиболее оптимальным.
         */
    }

    public static List<String> getLines1(String filename) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader(filename));
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        return list;
    }

    public static List<String> getLines2(String filename) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = Files.newBufferedReader(Paths.get(filename));
        while (reader.ready()) {
            list.add(reader.readLine());
        }
        return list;
    }

    public static List<String> getLines3(String filename) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = Files.newBufferedReader(Paths.get(filename));
        return reader.lines().collect(Collectors.toList());
    }
}
