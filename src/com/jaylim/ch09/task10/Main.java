package com.jaylim.ch09.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        /*List<Integer> list = getIntegers("aba-999adkf+100fff-777vgfcx-fsfds");
        for (Integer integer : list) {
            System.out.println(integer);
        }*/

        List<Integer> list = getIntegers2("aba-999adkf+100fff-777vgfcx-fsfds");
        for (Integer integer : list) {
            System.out.println(integer);
        }

        // FIXME: 10/31/2018 unresolved method 2
    }

    public static List<Integer> getIntegers(String s) {
        ArrayList<Integer> list = new ArrayList<>();

        Pattern pattern = Pattern.compile("([+-]?\\d+)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            Integer integer = Integer.parseInt(matcher.group(0));
            list.add(integer);
        }

        return list;
    }

    public static List<Integer> getIntegers2(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] array = s.split("([^0-9]+)");

        for (String s1 : array) {
            System.out.println(s1);
        }

        return list;
    }
}
