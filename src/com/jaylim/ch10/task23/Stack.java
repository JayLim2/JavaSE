package com.jaylim.ch10.task23;

import java.util.Arrays;

public class Stack {
    private Object[] values = new Object[10];
    private int size;

    public void push(Object newValue) {
        synchronized (values) {
            if (size == values.length)
                values = Arrays.copyOf(values, 2 * size);
            values[size] = newValue;
            size++;
        }
        /*
        1) нет модификатора volatile у int size
        это может привести к затиранию элементов в массиве

        2) синхронизация на изменяющемся объекте может привести
        к рассинхронизации, а именно: если возможно изменить
        поле, хранящее заблокированный объект,
        на который синхронизирован метод,
        то с момента изменения поля другие потоки могут
        получить доступ к данному блоку кода, т.к. синхронизация
        производится на том экземпляре, который был на момент
        достижения блока синхронизации.
         */
    }
    //...
}