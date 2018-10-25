package com.jaylim.ch06.task18_19;

import java.util.ArrayList;
import java.util.function.IntFunction;

public class Main {
    public static void main(String[] args) {
        //окажется неудачным, т.к. IntFunction<...> не может принимать примитивы
        //repeat(10, 42, int[]::new);

        //исправлено:
        Integer[] result = repeat(10, 42, Integer[]::new);
        /*for (Integer integer : result) {
            System.out.println(integer);
        }*/
    }

    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
        T[] result = constr.apply(n);
        for (int i = 0; i < n; i++) result[i] = obj;
        return result;
    }

    /**
     * Chapter 6
     * Task 19
     *
     * @param n
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> repeat(int n, T obj) {
        ArrayList<T> result = new ArrayList<>(); // OK
        for (int i = 0; i < n; i++) result.add(obj);
        return result;
        /*
        Нельзя просто так взять и преобразовать список в массив T[]
        т.к. либо получается массив Object[], который не просто
        скрывает типом Object истинный тип элемента - он хранит
        непосредственно Object, а соответственно, пересозданные
        объекты нельзя преобразовать обратно в T.

        Чтобы избежать этого нужна либо ссылка на конструктор,
        либо объект типа Class.
         */
    }
}
