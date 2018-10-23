package com.jaylim.ch05.task06;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        String filename = "task06.txt";
        variant1(filename);
        variant2(filename);
        variant3(filename);
    }

    /**
     * Catching in finally
     *
     * @param filename
     */
    public static void variant1(String filename) {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(new File(filename).toPath(), StandardCharsets.UTF_8);
            //read
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println("Exception during close file buffered reader.");
                }
            }
        }
    }

    /**
     * Try/finally in try/catch
     *
     * @param filename
     */
    public static void variant2(String filename) {
        BufferedReader in = null;
        try {
            try {
                in = Files.newBufferedReader(new File(filename).toPath(), StandardCharsets.UTF_8);
                //read
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }

    /**
     * Try with resources
     *
     * @param filename
     */
    public static void variant3(String filename) {
        try (BufferedReader in = Files.newBufferedReader(new File(filename).toPath(), StandardCharsets.UTF_8)) {
            //read
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }

}
