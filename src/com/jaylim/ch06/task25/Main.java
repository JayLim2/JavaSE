package com.jaylim.ch06.task25;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(
                genericDeclaration(
                        Main.class.getMethod("test2", List.class)));
    }

    public static String genericDeclaration(Method m) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(m.toGenericString());

        /*stringBuilder.append("\n");
        Type[] parameterTypes = m.getParameterTypes();
        Type[] genericParameterTypes = m.getGenericParameterTypes();
        for (Type type : parameterTypes) {
            stringBuilder.append(type);
        }
        stringBuilder.append("\n");
        for (Type genericParameterType : genericParameterTypes) {
            stringBuilder.append(genericParameterType);
        }*/

        return stringBuilder.toString();
    }

    public static <T> void test(List<T> list) {
    }

    public static void test2(List list) {
    }
}
