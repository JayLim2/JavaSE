package com.jaylim.ch08.task14;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Double> stream = Stream.of(5d, 7d, 14.5, 21.3);
        final AtomicInteger count = new AtomicInteger();
        Stream<Double> doubles = Stream.of(1.11, 2.22, 3.33, 4.44, 5.55);
        Double avg = doubles
                .reduce(0.0,
                        (x, y) -> {
                            int number = count.incrementAndGet();
                            return (x * (number - 1) + y) / number;
                        }
                );
        System.out.println("avg " + avg);

        /*
        Нельзя вычислить сумму методом sum() или reduce() т.к.
        они являются операциями сведения. Попытка после них вызвать
        метод count() обернется исключением: "операция уже применена
        либо поток закрыт"
         */
    }
}
