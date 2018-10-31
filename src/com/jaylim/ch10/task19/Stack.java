package com.jaylim.ch10.task19;

public class Stack {
    /*
    Проблема возникнет из-за неатомарности операций push/pop.

    1) push
    Один поток начинает операцию push,
    другой в этот же момент начинает операцию pop.

    Предположим, что pop выполнится быстрее
    Тогда в операции push может остаться старая ссылка top,
    т.к. переменная не помечена volatile.
    Соответственно, новый элемент будет добавлен не в
    в вершину стека.

    2) pop
    Аналогично, один поток начинает pop,
    другой в этот момент начинает push.

    Предположим, что push выполнится раньше.
    Тогда в операции pop будет, опять же, неверная ссылка top.
    Соответственно, результат удалит и вернет НЕ ВЕРШИНУ СТЕКА,
    а другой элемент.
     */

    class Node {
        Object value;
        Node next;
    }

    private Node top;

    public void push(Object newValue) {
        Node n = new Node();
        n.value = newValue;
        n.next = top;
        top = n;
    }

    public Object pop() {
        if (top == null) return null;
        Node n = top;
        top = n.next;
        return n.value;
    }
}