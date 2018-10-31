package com.jaylim.ch10.task04;

import java.util.Arrays;
import java.util.Formatter;
import java.util.function.BinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class Main {
    public static void main(String[] args) {
        Matrix matr = new Matrix(2);
        matr.set(0, 0, 156);
        matr.set(0, 1, 24);
        matr.set(1, 0, 11);
        matr.set(1, 1, 3);

        Matrix matr2 = new Matrix(2);
        matr2.set(0, 0, 25);
        matr2.set(0, 1, 7);
        matr2.set(1, 0, 99);
        matr2.set(1, 1, 6);

        Matrix mul = matr.mul(matr2);

        int[] matrices = fib(5);
        for (int i : matrices) {
            System.out.print(i + " ");
        }
    }

    private static int[] fib(int n) {
        Matrix[] arr = new Matrix[n >= 0 ? n : 0];
        Arrays.parallelSetAll(arr, new IntFunction<Matrix>() {
            @Override
            public Matrix apply(int value) {
                Matrix matrix = new Matrix(2);
                matrix.set(0, 0, 1);
                matrix.set(0, 1, 1);
                matrix.set(1, 0, 1);
                matrix.set(1, 1, 0);
                return matrix;
            }
        });

        Arrays.parallelPrefix(arr, new BinaryOperator<Matrix>() {
            @Override
            public Matrix apply(Matrix matrix, Matrix matrix2) {
                return matrix.mul(matrix2);
            }
        });

        int[] fib = new int[n + 1];
        fib[0] = 1;
        for (int i = 1; i <= n; i++) {
            fib[i] = arr[i - 1].get(0, 0);
        }

        return fib;
    }
}

class Matrix {
    private int[][] values;
    private int size;

    public Matrix(int n) {
        size = n;
        values = new int[n][n];
    }

    public int get(int i, int j) {
        return size > 0 && i < size && j < size ? values[i][j] : 0;
    }

    public void set(int i, int j, int val) {
        if (size > 0 && i < size && j < size) {
            values[i][j] = val;
        }
    }

    public int[] getRow(int i) {
        return size > 0 && i < size ? values[i] : null;
    }

    public int[] getCol(int j) {
        int[] col = size > 0 && j < size ? new int[size] : null;
        if (col != null) {
            for (int i = 0; i < size; i++) {
                col[i] = get(i, j);
            }
        }
        return col;
    }

    public Matrix mul(Matrix other) {
        Matrix result = new Matrix(size);

        for (int i = 0; i < size; i++) {
            int[] row = getRow(i);
            for (int j = 0; j < size; j++) {
                result.set(i, j, mulRowAndCol(row, other.getCol(j)));
            }
        }

        return result;
    }

    private int mulRowAndCol(int[] row, int[] col) {
        if (row == null || col == null) {
            throw new NullPointerException("Row or column is null.");
        }

        int result = 0;
        for (int i = 0; i < row.length; i++) {
            result += row[i] * col[i];
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter f = new Formatter();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                stringBuilder.append(get(i, j) + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
