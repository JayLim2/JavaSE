package com.jaylim.ch04.task10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[0];
        getAllMethods(arr);
    }

    private static void getAllMethods(Object classInstance) {
        Class<?> cl = classInstance.getClass();
        while (cl != null) {
            Method[] methods = cl.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(
                        Modifier.toString(method.getModifiers()) + " " +
                                method.getReturnType().getCanonicalName() + " " +
                                method.getName() + Arrays.toString(method.getParameters())
                );
            }
            cl = cl.getSuperclass();
        }
    }
}
