package com.jaylim.ch14.task10;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = getPipe("dir", "findstr \".txt\"");
        Process process = processBuilder.start();
        try (Scanner scanner = new Scanner(process.getInputStream())) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

    public static ProcessBuilder getPipe(String... commands) {
        List<String> commandList = new ArrayList<>();
        commandList.add("cmd.exe");
        commandList.add("/C");
        StringBuilder commandPipe = new StringBuilder();
        for (int i = 0; i < commands.length; i++) {
            commandPipe.append(commands[i]);
            if (i != commands.length - 1) {
                commandPipe.append(" | ");
            }
        }
        commandList.add(commandPipe.toString());
        return new ProcessBuilder(commandList);
    }
}
