package com.jaylim.ch10.task02;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 50*1000;
        int[] arr1 = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr1[i] = random.nextInt(10*size);
        }
        long t1 = System.currentTimeMillis();
        Arrays.sort(arr1);
        long t2 = System.currentTimeMillis();

        int[] arr2 = new int[size];
        for (int i = 0; i < size; i++) {
            arr2[i] = random.nextInt(10*size);
        }
        long t3 = System.currentTimeMillis();
        Arrays.parallelSort(arr2);
        long t4 = System.currentTimeMillis();

        System.out.println(t2-t1);
        System.out.println(t4-t3);

        /*
        В зависимости от особенностей работы процессора
        в опредленные моменты заметно, что последовательная
        сортировка даже на большом количестве БЫСТРЕЕ, чем
        параллельная

        Однако в среднем примерно при 40 000+ элементах в int[]
        массиве он сортируется быстрее ПАРАЛЛЕЛЬНОЙ СОРТИРОВКОЙ.
        При 100 000+ разрыв во времени сортировки уже значителен,
        поэтому для сотен тысяч элементов стоит применять ПАРАЛЛ.
         */
    }
}
