package com.jaylim.ch10.task09;

import java.util.concurrent.atomic.LongAccumulator;

public class Main {
    public static void main(String[] args) {
        LongAccumulator accumulator = new LongAccumulator(Long::max, 0);
        accumulator.accumulate(100);
        accumulator.accumulate(576);
        accumulator.accumulate(-99);
        System.out.println(accumulator.get());

        accumulator = new LongAccumulator(Long::min, 0);
        accumulator.accumulate(100);
        accumulator.accumulate(576);
        accumulator.accumulate(-99);
        System.out.println(accumulator.get());
    }
}
