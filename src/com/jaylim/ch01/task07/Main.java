package com.jaylim.ch01.task07;

public class Main {
    private static final int sOffset = 32768;

    public static void main(String[] args) {
        short firstValue = stringToShort("2");
        short secondValue = stringToShort("65535");

        System.out.println("firstValue[short]: " + firstValue);
        System.out.println("secondValue[short]: " + secondValue);

        System.out.println("firstValue[original]: " + shortToInt(firstValue));
        System.out.println("secondValue[original]: " + shortToInt(secondValue));

        System.out.println("summing: " + (shortToInt(firstValue) + shortToInt(secondValue)));
        System.out.println("multiplication: " + (shortToInt(firstValue) * shortToInt(secondValue)));
        System.out.println(Short.toUnsignedInt(firstValue));
    }

    private static short stringToShort(String value) {
        return (short) (Integer.parseInt(value) - sOffset);
    }

    private static int shortToInt(short value) {
        return value + sOffset;
    }

    private static int mul(short a, short b) {
        return (a + sOffset) * (b + sOffset);
    }

    private static int add(short a, short b) {
        return (a + sOffset) + (b + sOffset);
    }

    private static int dif(short a, short b) {
        return (a + sOffset) - (b + sOffset);
    }

    private static int div(short a, short b) {
        return (a + sOffset) / (b + sOffset);
    }
}
