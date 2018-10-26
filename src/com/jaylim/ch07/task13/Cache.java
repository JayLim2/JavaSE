package com.jaylim.ch07.task13;

import java.util.LinkedHashMap;

public class Cache<K, V> extends LinkedHashMap<K, V> {
    private int maxSize;

    public Cache(int maxSize) {
        super();
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public V put(K key, V value) {
        if (size() == maxSize)
            throw new IndexOutOfBoundsException("Cache cannot contains more elements than defined in maxSize.");
        return super.put(key, value);
    }
}
