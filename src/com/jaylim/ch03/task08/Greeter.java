package com.jaylim.ch03.task08;

public class Greeter implements Runnable {

    private String target;
    private int n;

    public Greeter() {
        target = "";
        n = 0;
    }

    public Greeter(String target, int n) {
        this.target = target;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println("Hello " + target);
        }
    }
}
