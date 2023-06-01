package com.yearup.deli;
public class Meat extends Topping {
    private boolean extra;
    public Meat(String type, int sandwichSize, Sandwich sandwich) {
        super(type, sandwichSize, sandwich);
        this.extra = false;
    }
    @Override
    public double getPrice() {
        double price = 0.0;
        switch (sandwichSize) {
            case 4:
                price = 1.00;
                break;
            case 8:
                price = 2.00;
                break;
            case 12:
                price = 3.00;
                break;
            default:
                System.out.println("Invalid sandwich size.");
        }
        if (extra) {
            price += calculateExtraMeatPrice();
        }
        return price;
    }
    public boolean isExtra() {
        return extra;
    }
    public void setExtra(boolean extra) {
        this.extra = extra;
    }
    private double calculateExtraMeatPrice() {
        double extraMeatPrice = 0.0;
        switch (sandwichSize) {
            case 4:
                extraMeatPrice = 0.50;
                break;
            case 8:
                extraMeatPrice = 1.00;
                break;
            case 12:
                extraMeatPrice = 1.50;
                break;
            default:
                System.out.println("Invalid sandwich size.");
        }
        return extraMeatPrice;
    }
}