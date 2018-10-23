package com.jaylim.ch04.task12;

public class Main {
    public static void main(String[] args) throws Exception {
        double startTime = System.currentTimeMillis();
        double endTime;
        System.out.println("Hello world");
        endTime = System.currentTimeMillis();

        double startReflectTime = endTime;
        double endReflectTime;
        com.jaylim.ch04.task11.Main.printHW();
        endReflectTime = System.currentTimeMillis();

        System.out.println(endTime - startTime + 1);
        System.out.println(endReflectTime - startReflectTime + 1);

        //при рефлексии время выполнения при прочих равных условиях
        //больше, чем при обычном вызове
    }
}
