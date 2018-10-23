package com.jaylim;

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

class ConstantSequence implements IntSequence {
    public IntSequence constant(int val) {
        return new IntSequence() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public int next() {
                return val;
            }
        };
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public int next() {
        return 0;
    }
}
