package com.jaylim.ch09.task03;

import java.io.File;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream(new File("task03"));
        int current = in.read();
        while (current != -1) {

        }
    }
}
