package com.jaylim.ch11.task09;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRun {
    public static void main(String[] args) throws Exception {
        String res = runTests(MyMath.class);
        System.out.println(res);
    }

    //Тест рассчитан под конкретный пример с методом факториала
    public static String runTests(Class<?> cl) throws IllegalAccessException, InvocationTargetException {
        StringBuilder stringBuilder = new StringBuilder();

        Method[] methods = cl.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            methods[i].setAccessible(true);
            Annotation[] methodAnnotations = methods[i].getAnnotationsByType(TestCase.class);
            for (int j = 0; j < methodAnnotations.length; j++) {
                TestCase testCase = (TestCase) methodAnnotations[j];
                String[] params = testCase.params().split(", ");
                Object result = methods[i].invoke(null, Integer.parseInt(params[0])); // FIXME: 03.11.2018
                if (result.toString().equals(testCase.expected())) {
                    stringBuilder.append("test case ").append(j).append(" passed\n");
                } else {
                    stringBuilder.append("test case ").append(j).append(" failed\n");
                }
            }
        }

        return stringBuilder.toString();
    }
}
