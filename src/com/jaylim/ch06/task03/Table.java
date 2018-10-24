package com.jaylim.ch06.task03;

import java.util.ArrayList;

public class Table<K, V> {
    private ArrayList<Entry<K, V>> list;

    public Table() {
        list = new ArrayList<>();
    }

    public V get(K key) {
        V value = null;
        for (int i = 0; i < list.size() && value == null; i++) {
            if (list.get(i).getKey().equals(key)) {
                value = list.get(i).getValue();
            }
        }
        return value;
    }

    public void set(K key, V value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                list.get(i).setValue(value);
                return;
            }
        }
        list.add(new Entry<>(key, value));
    }

    public Entry<K, V> remove(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return list.remove(i);
            }
        }
        return null;
    }
}

