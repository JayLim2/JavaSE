package com.jaylim.ch07.task15;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.IntFunction;

public class IntegerImmutableList implements List<Integer> {
    private IntFunction<Integer> function;

    public IntegerImmutableList(IntFunction<Integer> function) {
        this.function = function;

    }

    public IntFunction<Integer> getFunction() {
        return function;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Collection is infinite.");
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Iterator<Integer> iterator = iterator();
        while (iterator.hasNext()) {
            Integer current = iterator.next();
            if (o.equals(current)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Integer current = 0;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                current = function.apply(current);
                return current;
            }
        };
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("You cannot convert infinite collection to array.");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("You cannot create generic array.");
    }

    @Override
    public boolean add(Integer integer) {
        throw new UnsupportedOperationException("You cannot add element to immutable list.");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("You cannot remove element from Immutable list.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        throw new UnsupportedOperationException("You cannot add elements to immutable list.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        throw new UnsupportedOperationException("You cannot add elements to immutable list.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("You cannot remove elements from immutable list.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("You cannot retain elements.");
    }

    @Override
    public void clear() {
        removeAll(this);
    }

    @Override
    public Integer get(int index) {
        Integer element = 0;
        for (int i = 0; i < index; i++) {
            element = function.apply(element);
        }
        return element;
    }

    @Override
    public Integer set(int index, Integer element) {
        throw new UnsupportedOperationException("You cannot change element in immutable list.");
    }

    @Override
    public void add(int index, Integer element) {
        throw new UnsupportedOperationException("You cannot add element to immutable list.");
    }

    @Override
    public Integer remove(int index) {
        throw new UnsupportedOperationException("You cannot remove element from immutable list.");
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Iterator<Integer> iterator = iterator();
        while (iterator.hasNext()) {
            Integer current = iterator.next();
            if (o.equals(current)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return indexOf(o);
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return (ListIterator<Integer>) iterator();
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        Iterator<Integer> iterator = iterator();
        while (iterator.hasNext() && iterator.next() < index) ;
        return (ListIterator<Integer>) iterator;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("You cannot starts with any index.");
    }
}