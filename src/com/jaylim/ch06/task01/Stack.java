package com.jaylim.ch06.task01;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private List<E> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public void push(E element) {
        list.add(0, element);
    }

    public E pop() {
        return list.remove(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
