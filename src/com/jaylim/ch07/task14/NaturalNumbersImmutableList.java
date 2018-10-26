package com.jaylim.ch07.task14;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NaturalNumbersImmutableList implements List<Integer> {
    private Integer size;

    public NaturalNumbersImmutableList(Integer n) {
        size = n > 0 ? n : 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return (Integer) o >= 0 && (Integer) o < size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Integer current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public Integer next() {
                return current++;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
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
        return index >= 0 && index < size ? index : null;
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
        return contains(o) ? (Integer) o : -1;
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