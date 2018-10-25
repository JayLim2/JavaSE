package com.jaylim.ch06.task23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        /*
        Данный метод стирает тип до Throwable
        По факту никакого приведения типов не происходит.
        Однако, приведение типа без этого метода возможно,
        но необходимо проверять class cast, т.к. может быть
        сгенерировано ClassCastException
         */
    }
}

class Exceptions {
    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable e) throws T {
        throw (T) e; // The cast is erased to (Throwable) e
    }

    public static <V> V doWork(Callable<V> c) {
        try {
            return c.call();
        } catch (Throwable ex) {
            Exceptions.<RuntimeException>throwAs(ex);
            return null;
        }
    }
}
