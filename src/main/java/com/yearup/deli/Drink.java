package com.yearup.deli;

public class Drink extends Product implements IPrice{
    private int size;

    public Drink(String type, int size) {
        super(type);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    @Override
    public double getPrice(){
        double price = 0.0;
        if (size == 1){
            price = 2.00;
        } else if (size == 2) {
            price = 2.50;
        } else if (size == 3) {
            price = 3.00;

        } return price;
    }
}
