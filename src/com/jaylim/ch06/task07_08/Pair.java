package com.jaylim.ch06.task07_08;

public class Pair<E extends Comparable<E>> {
    private E first;
    private E second;

    public Pair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public E max() {
        return first != null && first.compareTo(second) > 0 ? first : second;
    }

    public E min() {
        return first != null && first.compareTo(second) < 0 ? first : second;
    }
}
