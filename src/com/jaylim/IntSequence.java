package com.jaylim;

public interface IntSequence {
    static IntSequence of(int... values) {
        return new IntSequence() {
            int[] seq = values;
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < seq.length;
            }

            @Override
            public int next() {
                return seq[i++];
            }
        };
    }

    static IntSequence constant(int constant) {
        return null;
    }

    boolean hasNext();

    int next();
}
