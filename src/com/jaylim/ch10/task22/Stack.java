package com.jaylim.ch10.task22;

import java.util.concurrent.locks.ReentrantLock;

public class Stack {
    public void push(Object newValue) {
        synchronized (new ReentrantLock()) {
            /*
            Каждый раз, входя в синхронизированный блок,
            поток пытается заблокировать объект, с которым
            связан блок, а если блокировка уже наложена -
            поток кидается в wait-set

            Если каждй раз создается новый объект,
            то смысла в такой блокировке никакого нет, т.к.
            новый объект безусловно будет без блокировки и
            поток беспрепятственно зайдет в метод.
             */
        }
    }
    //...
}
