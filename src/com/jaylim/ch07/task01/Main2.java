package com.jaylim.ch07.task01;

import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//BitSet
public class Main2 {
    public static void main(String[] args) {
        BitSet set = sieve(31);
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static BitSet sieve(int n) {
        BitSet bitSet = new BitSet(n);
        for (int i = 2; i <= n; i++) {
            bitSet.set(i);
        }

        Integer s = bitSet.nextSetBit(0);
        while (s * s <= n) {
            BitSet toRemoveSet = getRemovedSet(s, n);
            toRemoveSet.flip(0, toRemoveSet.size() - 1);
            bitSet.and(toRemoveSet);
            s++;
        }

        return bitSet;
    }

    private static BitSet getRemovedSet(int s, int n) {
        BitSet result = new BitSet();
        int k = 0;
        while (s * (s + k) <= n) {
            result.set(s * (s + k));
            k++;
        }
        return result;
    }
}
