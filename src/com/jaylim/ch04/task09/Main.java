package com.jaylim.ch04.task09;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(toString(System.in));
        } catch (IllegalAccessException ex) {

        } catch (InstantiationException ex) {

        }
    }

    public static <T> String toString(T object) throws IllegalAccessException, InstantiationException {
        StringBuilder stringBuilder = new StringBuilder();

        Class<?> tClass = object.getClass();
        System.out.println(tClass.getCanonicalName());

        Field[] fields = tClass.getDeclaredFields();
        System.out.println(fields.length);

        for (Field field : fields) {
            field.setAccessible(true);
            stringBuilder.append(field.getName());
            stringBuilder.append(": ");
            stringBuilder.append(field.get(object));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}

