package com.jaylim.ch05.task05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        sumInts("task05.txt");
    }

    public static void sumInts(String filename) {
        Scanner scanner = null;
        PrintWriter pw = null;
        try {
            scanner = new Scanner(new FileReader(new File(filename)));
            pw = new PrintWriter(new File("out.txt"));

            int sum = 0;
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }

            if (new Random().nextBoolean()) {
                throw new Exception("test exception");
            }

            pw.print(sum);
        } catch (FileNotFoundException ex) {
            Logger.getGlobal().warning("Файл не найден.");
        } catch (Exception ex) {
            Logger.getGlobal().warning("Throwable");
        } finally {
            if (scanner != null) {
                scanner.close();
                Logger.getGlobal().info("Scanner is closed.");
            }
            if (pw != null) {
                pw.close();
                Logger.getGlobal().info("PrintWriter is closed.");
            }
        }
    }
}
