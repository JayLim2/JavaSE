package com.jaylim;

import java.util.ArrayList;

public class Invoice {
    private static class Item {
        String description;
        int quantity;
        double unitPrice;

        double price() {
            return quantity * unitPrice;
        }
    }

    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(String description, int quantity, double unitPrice) {
        Item newItem = new Item();

        newItem.description = description;
        newItem.quantity = quantity;
        newItem.unitPrice = unitPrice;

        items.add(newItem);
    }

    public void printInvoice() {
        System.out.printf("%15s %18s %10s %10s %n", "Описание", "Количество (шт.)", "Цена за шт.", "Итог");
        int totalQuantity = 0;
        double totalPrice = 0;
        for (Item item : items) {
            totalQuantity += item.quantity;
            totalPrice += item.price();
            System.out.printf("%15s %18d %10.2f %10.2f %n", item.description, item.quantity, item.unitPrice, item.price());
        }
        System.out.printf("%32s %n", "========================================");
        System.out.printf("%15s %18d %10s %10.2f", "Итого:", totalQuantity, "-", totalPrice);
    }
}
