package com.jaylim.ch08.task06;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(isWord("abacaba"));
        System.out.println(isWord("abacab1a"));
    }

    public static boolean isWord(String s) {
        IntStream codePoints = s.codePoints();
        return codePoints.allMatch(Character::isAlphabetic);
    }
}
