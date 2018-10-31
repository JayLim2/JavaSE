package com.jaylim.ch10.task21;

public class Stack {
    private Object myLock = "LOCK";

    public void push(Object newValue) {
        synchronized (myLock) {
            /*
                Нефинализованное поле можно изменить.
                Если другой поток изменит поле, в которм хранится
                заблокированный объект, то он сможет беспрепятственно
                зайти в этот же блок.
             */
        }
    }
    //...
}