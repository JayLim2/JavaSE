package com.jaylim.ch02.task10;

import java.util.ArrayList;
import java.util.Random;

/**
 * Chapter 2
 * Task 10
 */
public class RandomNumbers {
    private static final Random random = new Random();

    public static Integer randomElement(Integer... arr) {
        Integer result = 0;

        if (arr.length != 0) {
            result = arr[random.nextInt(arr.length)];
        }

        return result;
    }

    public static Integer randomElement(ArrayList<Integer> arr) {
        Integer result = 0;

        if (arr.size() != 0) {
            result = arr.get(random.nextInt(arr.size()));
        }

        return result;
        //return randomElement((Integer[])arr.toArray());
    }
}
