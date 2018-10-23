package com.jaylim.ch04.task11;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        printHW();
    }

    public static void printHW() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> cl = System.class;
        Field field = cl.getField("out");
        Method println = field.getType().getDeclaredMethod("println", String.class);
        println.invoke(field.get(null), "Hello world");
    }
}
