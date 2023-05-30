package com.yearup.deli;

public abstract class Product implements IPrice {
    private String type;
    private double price;

    public Product(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
