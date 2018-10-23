package com.jaylim.ch03.task06;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Iterator<Integer> iterator = new DigitSequence();

    }
}

class DigitSequence implements Iterator<Integer> {
    Integer i = 0;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return i++;
    }

    @Override
    public void remove() {
    }
}
