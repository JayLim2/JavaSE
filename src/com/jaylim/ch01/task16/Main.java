package com.jaylim.ch01.task16;

public class Main {
    public static void main(String[] args) {
        System.out.println(average(100));
    }

    public static double average(double... values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }

        return values.length == 0 ? 0 : sum / values.length;
    }
}
