package com.jaylim.ch03.task05;

/**
 * Chapter 3
 * Task 5
 */
public class DigitSequence {
    public static void main(String[] args) {
        IntSequence seq = IntSequence.of(1, 5, 7, 8, 31, 46);
        while (seq.hasNext()) {
            System.out.println(seq.next());
        }
    }
}

