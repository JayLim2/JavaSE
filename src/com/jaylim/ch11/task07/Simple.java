package com.jaylim.ch11.task07;

public class Simple {
    @Param(type = String.class)
    @Param(type = int.class)
    @Return(type = Object.class)
    public static Object getObject(String key, int value) {
        return key + " -> " + value;
    }
}
