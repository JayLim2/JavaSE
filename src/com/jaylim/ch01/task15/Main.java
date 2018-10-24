package com.jaylim.ch01.task15;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = pascal(8);

        for (ArrayList<Integer> integers : triangle) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    //Pascal triangle
    public static ArrayList<ArrayList<Integer>> pascal(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int k = 0; k <= i; k++) {
                row.add(combination(i, k));
            }
            triangle.add(row);
        }

        return triangle;
    }

    public static int combination(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static int factorial(int n) {
        int i = 1;
        for (int j = 1; j <= n; j++) {
            i *= j;
        }
        return i;
    }
}
