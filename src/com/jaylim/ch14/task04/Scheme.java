package com.jaylim.ch14.task04;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Scheme {
    public static void main(String[] args) throws ScriptException {
        /*
        (define fact
          (lambda (n)
            (if (= n 0) 1
                (* n (fact (- n 1)))))
         */
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("kawa");
        if (engine != null) {
            String fact = "(define (factorial x)\n" +
                    "  (if (< x 2)\n" +
                    "    1\n" +
                    "    (* x (factorial (- x 1)))))";
            engine.eval(fact);
            engine.eval("(do ((i 0 (+ i 1)))\n" +
                    "  ((> i 16))\n" +
                    "    (display (string-append (number->string i) \"! = \"))\n" +
                    "    (display (number->string (factorial i)))\n" +
                    "    (newline))");
        }
    }
}
