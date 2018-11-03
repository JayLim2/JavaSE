package com.jaylim.ch11.task05;

@ToDo(message = "add new fields")
public class Simple {
    @ToDo(message = "change type of key to generic")
    private String key;
    private int value;

    @ToDo(message = "new format")
    public String getEntry() {
        return key + " -> " + value;
    }
}
