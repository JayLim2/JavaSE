package com.jaylim.ch10.task20;

public class Queue {
    class Node {
        Object value;
        Node next;
    }

    private Node head;
    private Node tail;

    public void add(Object newValue) {
        Node n = new Node();
        if (head == null) head = n;
        else tail.next = n;
        tail = n;
        tail.value = newValue;
        /*
        1)
        модификация tail.next может быть неверной,
        если другой поток уже модифицировал очередь и
        объект, на который указывает tail, другой
         */
    }

    public Object remove() {
        if (head == null) return null;
        Node n = head;
        head = n.next;
        return n.value;
        /*
        2)
        модификация n.next, n.value может быть неверной,
        если другой поток уже модифицировал очередь и
        объект, на который указывает head, другой
         */
    }
}
