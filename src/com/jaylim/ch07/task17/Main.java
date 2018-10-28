package com.jaylim.ch07.task17;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Object integers = new ArrayList<Integer>();
        ((ArrayList) integers).add(100);

        @SuppressWarnings("unchecked")
        ArrayList<String> strings = (ArrayList<String>) integers;
        System.out.println(strings.get(0));
        /*
        В данном примере происходит загрязнение "кучи", т.к.
        якобы хранится список строк, но по факту - список чисел.
        Это приводит к ClassCastException при извлечении.

        Злоупотребление SuppressWarning может приводит к подобным
        ошибкам.
         */
    }
}
