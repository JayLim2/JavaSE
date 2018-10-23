package com.jaylim.ch03.task08;

public class Main {
    public static void main(String[] args) {
        Runnable task1 = new Greeter("bastard", 7);
        Runnable task2 = new Greeter("jellyfish", 12);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
    }
}
