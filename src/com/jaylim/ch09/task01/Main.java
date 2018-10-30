package com.jaylim.ch09.task01;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {
        try {
            copy2(new DataInputStream(new FileInputStream("input.txt")), new DataOutputStream(new FileOutputStream("outp.txt")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void copy(InputStream in, OutputStream out) throws IOException {
        int currentByte = in.read();
        while (currentByte != -1) {
            out.write(currentByte);
            currentByte = in.read();
        }
        in.close();
        out.close();
    }

    public static void copy2(InputStream in, OutputStream out) throws IOException {
        Path file = Files.createTempFile("pref", "suf");
        Files.copy(in, file, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(file, out);
        in.close();
        out.close();
    }
}
