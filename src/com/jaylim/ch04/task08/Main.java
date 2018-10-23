package com.jaylim.ch04.task08;

import com.jaylim.ch04.task01_02_03.Point;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        test(1, 2, 3);             //array
        test(100);                  //primitive
        test(new Point(10, 22));   //generic type
    }

    /**
     * Chapter 04
     * Task 08
     *
     * @param obj
     */
    public static void test(Integer... obj) {
        Class cl = obj.getClass();

        System.out.println(cl.toString());
        System.out.println(cl.toGenericString());
        System.out.println(cl.getName());
        System.out.println(cl.getCanonicalName());
        System.out.println(cl.getSimpleName());
        System.out.println(cl.getTypeName());
        System.out.println(" \n ===========");
    }

    public static <T> void test(T obj) {
        Class cl = obj.getClass();

        System.out.println(cl.toString());
        System.out.println(cl.toGenericString());
        System.out.println(cl.getName());
        System.out.println(cl.getCanonicalName());
        System.out.println(cl.getSimpleName());
        System.out.println(cl.getTypeName());
        System.out.println(" \n ===========");
    }

    public static void test(int obj) {
        Class cl = int.class;

        System.out.println(cl.toString());
        System.out.println(cl.toGenericString());
        System.out.println(cl.getName());
        System.out.println(cl.getCanonicalName());
        System.out.println(cl.getSimpleName());
        System.out.println(cl.getTypeName());
        System.out.println(" \n ===========");
    }
}
