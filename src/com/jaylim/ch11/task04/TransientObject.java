package com.jaylim.ch11.task04;

import java.io.Serializable;

public class TransientObject implements Serializable {
    private static TransientObject object;
    private long id = 1984;

    public static TransientObject get() {
        if (object == null) {
            object = new TransientObject();
        }
        return object;
    }
}
