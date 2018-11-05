package com.jaylim.ch14.task03;

import javax.script.*;
import java.io.BufferedReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        BufferedReader reader = Files.newBufferedReader(Paths.get("sort.js"));
        if (engine instanceof Invocable) {
            engine.eval(reader);
            Sort sort = ((Invocable) engine).getInterface(Sort.class);
            long time1 = System.currentTimeMillis();
            sort.sort(new int[]{1, 7, 9, -4, 2, 0, 11, 5, 3, 24, 9});
            long time2 = System.currentTimeMillis();
            System.out.println("time invocation: " + (time2 - time1));
        }

        reader = Files.newBufferedReader(Paths.get("sort.js"));
        if (engine instanceof Compilable) {
            StringBuilder scriptBuilder = new StringBuilder();
            while (reader.ready()) {
                scriptBuilder.append(reader.readLine()).append("\n");
            }
            scriptBuilder.append("var arr = [1, 7, 9, -4, 2, 0, 11, 5, 3, 24, 9];\n");
            scriptBuilder.append("sort(arr);");
            CompiledScript script = ((Compilable) engine).compile(scriptBuilder.toString());
            long time1 = System.currentTimeMillis();
            script.eval();
            long time2 = System.currentTimeMillis();
            System.out.println("time invocation compiled: " + (time2 - time1));
        }

        /*
        Выдача программы:

        -4
        0
        1
        2
        3
        5
        7
        9
        9
        11
        24
        time invocation: 2126

        -4
        0
        1
        2
        3
        5
        7
        9
        9
        11
        24
        time invocation compiled: 2151

        Таким образом, время выполнения данной программы примерно
        одинаковое как в интерпретируемом, так и в компилируемом виде.
         */
    }
}