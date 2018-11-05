package com.jaylim.ch14.task02;

public interface JSON {
    Object parse(String string);

    String stringify(Object object);
}
