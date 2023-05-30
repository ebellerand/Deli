package com.yearup.deli;

public class Chips extends Product implements IPrice{
    public Chips(String type) {
        super(type);
    }
    @Override
    public double getPrice() {
        return 1.50;
    }
}
