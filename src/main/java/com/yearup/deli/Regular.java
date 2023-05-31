package com.yearup.deli;

public class Regular extends Topping{

    public Regular(String type, int size, Sandwich sandwich) {
        super(type, sandwich.getSandwichSize(), sandwich);
    }

    public double getPrice() {
    double price = 0.0;
    return price;
}
}
