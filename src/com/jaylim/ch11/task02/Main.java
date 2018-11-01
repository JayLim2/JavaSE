package com.jaylim.ch11.task02;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomObjectOutputStream out = CustomObjectOutputStream.openStream("out.txt");
        out.writeObject(new Test());
        CustomObjectInputStream in = CustomObjectInputStream.openStream("out.txt");
        Test test = (Test) in.readObject();
        System.out.println(test);
    }
}

@Serializable
class Test {
    private int key = 10;
    private Object value = "String";

    public Test() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
