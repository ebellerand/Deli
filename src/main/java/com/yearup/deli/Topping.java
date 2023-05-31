package com.yearup.deli;

public class Topping extends Product implements IPrice{
    int sandwichSize;

    public Topping(String type, int sandwichSize, Sandwich sandwich) {
        super(type);
        this.sandwichSize = sandwich.getSandwichSize();
    }

    @Override
    public double getPrice() {
        return price;
    }
}
