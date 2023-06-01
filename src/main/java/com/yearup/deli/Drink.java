package com.yearup.deli;

public class Drink extends Product {
    private String size;

    public Drink(String type, String size) {
        super(type);
        this.size = size;
        this.price = getSizePrice(size);
    }

    public String getSize() {
        return size;
    }

    public double getSizePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0.00; // Invalid size, return a default price of 0.00
        }
    }

    @Override
    public double getPrice() {
        return price;
    }
}