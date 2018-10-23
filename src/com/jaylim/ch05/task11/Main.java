package com.jaylim.ch05.task11;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String tmp = null;
        //Objects.requireNonNull(tmp);
        assert tmp != null;

        /*
        Обычное исключение (NPE) проще разобрать.
        AssertionError не предоставляет достаточного
        количества информации об ошибке.

        Также ассерт занимает дополнительное время выполнения.
         */
    }
}
