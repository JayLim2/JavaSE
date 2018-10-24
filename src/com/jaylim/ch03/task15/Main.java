package com.jaylim.ch03.task15;

import com.jaylim.ch03.task05.IntSequence;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        IntSequence intSequence = randomInts(5, 15);
        for (int i = 0; i < 5; i++) {
            System.out.println(intSequence.next());
        }
    }

    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }

    private static class RandomSequence implements IntSequence {
        private Random generator = new Random();
        private int low;
        private int high;

        public RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }
    }
}
