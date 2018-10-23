package com.jaylim.ch02.task02_03;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //in stage of importing
        new Random().nextInt();
        new Scanner(System.in).nextInt();

        //Task 2
        /*
         * Random nextInt
         * Модифицирующий метод, потому что
         * изменяется seed после вычисления нового инта
         *
         * Scanner nextInt
         * Немодифицирующий, потому что
         * вычисляет новое значение и не меняет данные
         */

        //Task 3
        /*
        Модифицирующий метод может возвращать.
        Пример: remove() с возвратом удаленного элемента

        Метод доступа с возвратом void
        Не может быть, потому что в таком случае данные
        могут быть использованы при операции записи куда-либо.
         */
    }
}
