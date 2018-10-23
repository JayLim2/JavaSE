package com.jaylim.ch02;

import com.jaylim.Main;

public class Generics<T> {
    private T value;

    public Generics(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void print() {
        if (value instanceof Main) {

        }
    }
}
