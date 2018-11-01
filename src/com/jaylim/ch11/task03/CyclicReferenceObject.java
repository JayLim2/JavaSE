package com.jaylim.ch11.task03;

import java.io.Serializable;

public class CyclicReferenceObject implements Serializable {
    private static CyclicReferenceObject object;
    private long id = 42;

    public static CyclicReferenceObject get() {
        if (object == null) {
            object = new CyclicReferenceObject();
        }
        return object;
    }
}
