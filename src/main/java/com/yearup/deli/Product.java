package com.yearup.deli;

public abstract class Product implements IPrice {
    private String type;
    double price;

    public Product(String type) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
