package com.jaylim.ch04.task13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.DoubleFunction;

public class Main {
    public static void main(String[] args) throws Exception {
        //ofMethod(Math.class.getMethod("sqrt", double.class), 1, 144, 3);
        ofMethod(Math::sqrt, 1, 144, 3);

        /*
        Применение DoubleFunction в данном случае более безопасно,
        удобно и эффективно, т.к. сокращает код, избавляет от
        необходимости проверок и обращения к механизму рефлексии
         */
    }

    public static void ofMethod(Method method, double lowLim, double highLim, double step) throws InvocationTargetException, IllegalAccessException {
        if (method.getReturnType() != double.class
                || !Modifier.isStatic(method.getModifiers()))
            return;

        Class<?>[] paramTypes = method.getParameterTypes();
        if (paramTypes.length == 1 && paramTypes[0] == double.class) {
            double val = lowLim;
            method.setAccessible(true);
            while (Double.compare(val, highLim) <= 0) {
                System.out.println("val: " + val + ", method result: " + method.invoke(null, val));
                val += step;
            }
        }
    }

    public static void ofMethod(DoubleFunction<Object> method, double lowLim, double highLim, double step) throws InvocationTargetException, IllegalAccessException {
        double val = lowLim;
        while (Double.compare(val, highLim) <= 0) {
            System.out.println("val: " + val + ", method result: " + method.apply(val));
            val += step;
        }
    }
}

