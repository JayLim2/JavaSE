package com.jaylim.ch05.task10;

public class Main {
    public static void main(String[] args) {
        int f = factorial(6);
        System.out.println(f);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        new Exception("Factorial exception").printStackTrace();

        return n * factorial(n - 1);
    }
}
