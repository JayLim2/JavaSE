package com.jaylim.ch03.task09;

public class Main {
    public static void main(String[] args) {

    }

    public static void runTogether(Runnable... tasks) {
        for (int i = 0; i < tasks.length; i++) {
            new Thread(tasks[i]).start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        for (int i = 0; i < tasks.length; i++) {
            tasks[i].run();
        }
    }
}
