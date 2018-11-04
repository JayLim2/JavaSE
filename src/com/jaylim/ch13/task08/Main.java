package com.jaylim.ch13.task08;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int charMax = Character.MAX_VALUE;
        for (char i = 0; i < charMax; i++) {
            String normC = Normalizer.normalize(Character.toString(i), Normalizer.Form.NFKC);
            if (normC.length() > 1) {
                System.out.println(i);
                char[] chars = normC.toCharArray();
                for (int i1 = 0; i1 < chars.length; i1++) {
                    System.out.print(chars[i1] + " ");
                }
                /*char[] chars = normC.toCharArray();
                byte[] bytes = normC.getBytes(StandardCharsets.US_ASCII);
                for (int i1 = 0; i1 < bytes.length; i1++) {
                    System.out.print((int)bytes[i1]);
                    System.out.print(' ');
                    System.out.print((char)bytes[i1]);
                    System.out.print(' ');
                }*/
                System.out.println("\n\n");
            }
            //System.out.print(normC.length() > 1 ? normC + "\n" : "");
        }
    }
}
