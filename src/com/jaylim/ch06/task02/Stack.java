package com.jaylim.ch06.task02;

public class Stack<E> {
    private E[] array;
    private int length;
    private int stackPointer;

    public Stack() {
        array = (E[]) new Object[10];
        length = 0;
        stackPointer = array.length - length;
    }

    public void push(E element) {
        if (length == array.length) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = length - 1, k = 0; i >= 0; i--, k++) {
                newArray[newArray.length - k - 1] = array[array.length - k - 1];
            }
            array = (E[]) newArray;
            stackPointer = array.length - length;
        }
        stackPointer--;
        length++;
        array[stackPointer] = element;
    }

    public E pop() {
        E element = null;
        if (stackPointer < array.length) {
            element = (E) array[stackPointer++];
        }
        return element;
    }

    public boolean isEmpty() {
        return stackPointer >= array.length;
    }
}
