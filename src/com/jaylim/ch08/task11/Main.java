package com.jaylim.ch08.task11;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(0, integer -> integer + 1);
        System.out.println(isFinite(stream));
    }

    public static <T> boolean isFinite(Stream<T> stream) {
        long count = stream.count();
        return Double.compare(count, Double.POSITIVE_INFINITY) >= 0;
        /*
        Метод никогда не завершится, потому что подсчет
        элементов бесконечного потока будет выполняться
        бесконечно долго.
         */
    }
}
