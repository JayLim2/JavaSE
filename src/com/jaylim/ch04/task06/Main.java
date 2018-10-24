package com.jaylim.ch04.task06;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item();
        Item item2 = new Item();
        DiscountedItem discountedItem1 = new DiscountedItem();
        DiscountedItem discountedItem2 = new DiscountedItem();

        System.out.println(item1.equals(item2));
        System.out.println(discountedItem1.equals(item1));
        System.out.println(discountedItem1.equals(discountedItem2));
    }
}
