package com.jaylim.ch06.task09;

import com.jaylim.ch06.task05.Arrays;
import com.jaylim.ch06.task07_08.Pair;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("aaaa");
        strings.add("bbbb");
        strings.add("cccc");
        strings.add("dddd");
        strings.add("eeee");
        Pair<String> pair = Arrays.firstAndLast(strings);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}
