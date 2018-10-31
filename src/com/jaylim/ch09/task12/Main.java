package com.jaylim.ch09.task12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // компилировать шаблон регулярного выражения для
        // числа, состоящего из одного или более цифр
        String stringlist[] = {
                "abc -123 def",
                "456 ghi",
                "jkl++789mno"};

        Pattern patt = Pattern.compile("([+-]?\\d+)");

        for (int i = 0; i < stringlist.length; i++) {
            String currstr = stringlist[i];
            Matcher match = patt.matcher(currstr);

            if (match.find()) {
                System.out.println(currstr + " -> " + match.group(1));
            }
        }

        /*
        В данном примере в группу выделяется подстрока,
        соответствующая числу с его знаком

        Если нам не важен знак, мы можем вывести фактически модуль
        числа, вынося из группы шаблон [+-]? соответствующий знаку
         */
    }
}
