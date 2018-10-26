package com.jaylim.ch07.task16;

import com.jaylim.ch07.task13.Cache;
import com.jaylim.ch07.task15.IntegerImmutableList;

import java.util.Iterator;
import java.util.function.IntFunction;

public class CachedIntegerImmutableList extends IntegerImmutableList {
    private Cache<Integer, Integer> cache;
    private Iterator<Integer> iterator;

    public CachedIntegerImmutableList(IntFunction<Integer> function) {
        super(function);
        cache = new Cache<>(100);
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Integer current = 0;
            private int index = 0;
            private int minIndex = 0;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                Integer next = getFunction().apply(current);
                if (index++ >= 100) {
                    cache.remove(minIndex++);
                }
                cache.put(index, next);
                return next;
            }
        };
    }

    @Override
    public Integer get(int index) {
        if (cache.containsKey(index)) {
            System.out.println("get from cache: ");
            return cache.get(index);
        }
        return super.get(index);
    }

    @Override
    public int indexOf(Object o) {
        return super.indexOf(o);
    }
}
