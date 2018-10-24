package com.jaylim.ch05.task08;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        try (AutoCloseable stream = new AutoCloseable() {
            @Override
            public void close() throws Exception {
                //some actions to close
                lock.unlock();
            }
        }) {
            //something do
        } catch (Exception ex) {
            //catching
        }
    }
}
