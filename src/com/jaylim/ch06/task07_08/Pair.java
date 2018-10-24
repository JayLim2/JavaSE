package com.jaylim.ch06.task07_08;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Pair<E> {
    private E first;
    private E second;

    public Pair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public E max() {
        Class<?> cl = first.getClass();
        if (second.getClass() != cl) {
            return null;
        }

        try {
            Method method = cl.getDeclaredMethod("compareTo", cl);
            Object result = method.invoke(first, second);
            return (Integer) result > 0 ? first : second;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            return null;
        }
    }
}
