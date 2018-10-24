package com.jaylim.ch04.task06;

public class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem() {
        super();
        discount = 10;
    }

    public DiscountedItem(double discount) {
        super();
        this.discount = discount;
    }

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() == Item.class) {
            return super.equals(other);
        }

        if (other instanceof DiscountedItem) {
            DiscountedItem otherDI = (DiscountedItem) other;
            return super.equals(other) && Double.compare(discount, otherDI.discount) == 0;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
