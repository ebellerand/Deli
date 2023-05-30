package com.yearup.deli;

public class Topping extends Product implements IPrice{
    public Topping(String type) {
        super(type);
    }
    @Override
    public double getPrice() {
        double price = 0.0;
        return price;
    }
}
