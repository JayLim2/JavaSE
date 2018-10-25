package com.jaylim.ch06.task22;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 42;
            }
        };

        try {
            Integer a = doWork(callable, RuntimeException.class.getConstructor());
            Logger.getGlobal().info("result: " + a);
        } catch (NoSuchMethodException ex) {
            Logger.getGlobal().warning("No such constructor.");
        }
    }

    public static <V, T extends Throwable> V doWork(Callable<V> c, Constructor<T> constr) throws T {
        try {
            return c.call();
        } catch (Throwable realEx) {
            try {
                throw constr.newInstance(realEx);
            } catch (InstantiationException | InvocationTargetException | IllegalAccessException ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        }
    }
}
