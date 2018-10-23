package com.jaylim.ch03.task05;

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
