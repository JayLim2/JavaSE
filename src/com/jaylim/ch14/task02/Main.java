package com.jaylim.ch14.task02;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        String testJSONString = "{\"field1\":10,\"field2\":\"String\"}";
        engine.eval("var obj = JSON.parse('" + testJSONString + "')");
        engine.eval("print(obj.field1)");

        if (engine instanceof Invocable) {
            //invokeMethod
            Object json = engine.eval("JSON");
            Object object = ((Invocable) engine).invokeMethod(json, "parse", testJSONString);
            String string = ((Invocable) engine).invokeMethod(json, "stringify", object).toString();
            System.out.println(string);

            //интерфейс
            engine.eval("function parse(s) { return JSON.parse(s); }");
            engine.eval("function stringify(s) { return JSON.stringify(s); }");
            JSON json1 = ((Invocable) engine).getInterface(JSON.class);
            Object object1 = json1.parse(testJSONString);
            String string1 = json1.stringify(object1);
            System.out.println(string1);
        }
    }
}
