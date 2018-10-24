package com.jaylim.ch06.task05;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        Ошибка: несоответствующие типы.
        Обобщенный параметр переменной длины не может быть установлен,
        т.к. не ясно T - Integer или Double

        Решение ошибки:
        Добавить литерал d, показывающий явно, что число является
        double.
         */
        Double[] result = Arrays.swap(0, 1, 1d, 1.5d, 2d, 3d);
        //Double[] result = Arrays.<Double>swap(0, 1, 1, 1.5, 2, 3);

        for (Double aDouble : result) {
            System.out.println(aDouble);
        }
    }
}
