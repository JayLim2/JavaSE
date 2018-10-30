package com.jaylim.ch08.task15;

import org.omg.CORBA.IntHolder;

import java.math.BigInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<BigInteger> intStream = Stream.iterate(BigInteger.valueOf(Math.round(Math.pow(10, 50))), new UnaryOperator<BigInteger>() {
            @Override
            public BigInteger apply(BigInteger bigInteger) {
                return bigInteger.add(BigInteger.ONE);
            }
        }).limit(5000);
        intStream = intStream.filter(new Predicate<BigInteger>() {
            @Override
            public boolean test(BigInteger bigInteger) {
                return bigInteger.isProbablePrime(0);
            }
        }).limit(500);
        IntHolder i = new IntHolder(0);
        intStream.forEach(new Consumer<BigInteger>() {
            @Override
            public void accept(BigInteger bigInteger) {
                i.value = i.value + 1;
                System.out.println(i.value + ": " + bigInteger);
            }
        });

    }
}
