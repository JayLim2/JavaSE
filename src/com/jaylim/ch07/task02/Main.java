package com.jaylim.ch07.task02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aba");
        list.add("caba");
        list.add("daba");
        toUpperCaseAll2(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void toUpperCaseAll1(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(i).toUpperCase());
        }
    }

    public static void toUpperCaseAll2(ArrayList<String> arr) {
        int i = 0;
        for (String s : arr) {
            arr.set(i++, s.toUpperCase());
        }
    }

    public static void toUpperCaseAll3(ArrayList<String> arr) {
        arr.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        });
    }
}
