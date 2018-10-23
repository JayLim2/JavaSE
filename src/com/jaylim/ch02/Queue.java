package com.jaylim.ch02;

import java.util.Iterator;

public class Queue implements Iterable<Queue.Node> {
    public class Node {
        private String value;
        private Node next;
        private Node prev;

        public Node() {
            this(null);
        }

        public Node(String value) {
            this.value = value;
            next = null;
            prev = null;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    private Node head;

    public Queue() {
        head = new Node();
        head.next = head;
        head.prev = head;
    }

    public void add(String newString) {
        Node newNode = new Node(newString);
        head.prev.next = newNode;
        head.prev = newNode;
        newNode.prev = head;
        newNode.next = head;
    }

    public void remove() {
        head.next.next.prev = head;
        head.next = head.next.next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node p = head.next;
        while (p != head) {
            stringBuilder.append(p.value);
            stringBuilder.append("\n");
            p = p.next;
        }
        return stringBuilder.toString();
    }

    private class Iter implements Iterator<Node> {
        private Node current = head.next;

        @Override
        public boolean hasNext() {
            return current != head;
        }

        @Override
        public Node next() {
            Node next = current;
            if (current != null) {
                current = current.next;
                return next;
            } else {
                class QueueOutOfBoundsException extends RuntimeException {
                    public QueueOutOfBoundsException() {
                    }

                    public QueueOutOfBoundsException(String message) {
                        super(message);
                    }
                }

                throw new QueueOutOfBoundsException("No elements in queue.");
            }
        }
    }

    public Iterator<Node> iterator() {
        return new Iter();
    }
}
