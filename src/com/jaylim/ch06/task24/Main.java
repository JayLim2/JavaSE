package com.jaylim.ch06.task24;

public class Main {
    public static void main(String[] args) {
        Class<?> cl = Integer.class;
        try {
            Integer a = (Integer) cl.newInstance();
        } catch (Exception e) {
        }
        /*
        Все кроме newInstance, т.к. он возвращает
        capture of ?, поэтому требуется приведение
        к конкретному типу.
         */
    }
}
