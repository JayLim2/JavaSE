package com.jaylim.ch11.task09;

public class MyMath {
    @TestCase(params = "0", expected = "1")
    @TestCase(params = "4", expected = "24")
    public static long factorial(int n) {
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            fac *= i;
        }
        return fac;
    }
}
