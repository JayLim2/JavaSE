package com.jaylim.ch06.task16;

public class Main {
    public static void main(String[] args) {
        /*
        Стирание типов в методе:
        public static <T extends Comparable<? super T>>
        void sort(List<T> list)

        - приведет к тому, что придет список "сырых" объектов
        с полем типа Comparable

        ----------------------------------------

        Стирание типов в методе:
        public static <T extends Object & Comparable<? super T>>
        T max(Collection<? extends T> coll)

        - приведет к тому, что придет коллекция "сырых" объектов
        с полем типа Object (т.к. стираемый тип заменяется его
        первым ограничением)
         */
    }
}
