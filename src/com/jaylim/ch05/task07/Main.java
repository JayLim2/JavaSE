package com.jaylim.ch05.task07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        /*
        При закрытии ресурса Scanner ловит исключение,
        которое потенциально может быть сгенерировано.

        Подавляемое исключение сохраняется в поле lastException,
        к которому доступ организован через метод ioException()
         */
    }
}
