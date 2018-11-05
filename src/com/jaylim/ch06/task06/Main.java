package com.jaylim.ch06.task06;

import java.util.ArrayList;

import static javafx.scene.input.KeyCode.T;

public class Main {
    public static void main(String[] args) {

    }

    /*
    Мы не знаем какой точно тип расширяет тип Т, поэтому проще всего
    сохранить в общем супертипе Т.
     */
    public static <T> ArrayList<T> join1(ArrayList<? extends T> a,
                                         ArrayList<? extends T> b) {
        ArrayList<T> arrayList = new ArrayList<>();
        arrayList.addAll(a);
        arrayList.addAll(b);
        return arrayList;
    }

    /*
    Т.к. мы не знаем какой супертип типа Т хранится в полученных элементах
    (к слову в массивах могут быть разные супертипы!), проще всего сохранить
    списочный массив Object.
     */
    public static <T> ArrayList join2(ArrayList<? super T> a,
                                      ArrayList<? super T> b) {
        ArrayList arrayList = new ArrayList<>();
        arrayList.addAll(a);
        arrayList.addAll(b);
        return arrayList;
    }
}
