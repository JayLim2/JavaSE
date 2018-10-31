package com.jaylim.ch10.task08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) {
        long t1 = runTask1();
        long t2 = runTask2();
        System.out.println(t1);
        System.out.println(t2);

        /*
        При прочих равных, LongAdder работает минимум в 2 раза
        медленнее, чем AtomicLong
         */
    }

    public static long runTask1() {
        long t1 = System.currentTimeMillis();
        AtomicLong count = new AtomicLong(0);
        ExecutorService service = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        count.incrementAndGet();
                    }
                }
            });
        }
        long t2 = System.currentTimeMillis();
        service.shutdown();
        return t2 - t1;
    }

    public static long runTask2() {
        long t1 = System.currentTimeMillis();
        LongAdder count = new LongAdder();
        ExecutorService service = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000; j++) {
                        count.increment();
                    }
                }
            });
        }
        long t2 = System.currentTimeMillis();
        service.shutdown();
        return t2 - t1;
    }
}
