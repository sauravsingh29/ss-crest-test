package com.ss.item.request;

public class Order {

    private String item;
    private int    quantity;
    private float  price;

    /**
     * Field constructor to avoid setter
     * 
     * @param item
     * @param quantity
     * @param price
     */
    public Order(String item, int quantity, float price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Order [item=");
        builder.append(item);
        builder.append(", quantity=");
        builder.append(quantity);
        builder.append(", price=");
        builder.append(price);
        builder.append("]");
        return builder.toString();
    }
}
