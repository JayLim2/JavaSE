package com.jaylim.ch14.task11;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String command = "cmd /c set >> d:\\set.txt";
        Process child = Runtime.getRuntime().exec(command);

        Map<String, String> map = System.getenv();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry);
        }

        /*
        jjs -scripting
        for(var i in $ENV) print(i + " = " + $ENV[i])
         */
    }
}
