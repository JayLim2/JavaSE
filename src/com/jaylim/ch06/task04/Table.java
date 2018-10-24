package com.jaylim.ch06.task04;

import java.util.ArrayList;

/*
Вложенный класс не обязательно должен быть типизирован,
т.к. вложенный класс также имеет доступ к параметрам типа
объемлющего класса.
 */

public class Table<K, V> {
    private class Entry {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private ArrayList<Entry> list;

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
        list.add(new Entry(key, value));
    }

    public Entry remove(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return list.remove(i);
            }
        }
        return null;
    }
}