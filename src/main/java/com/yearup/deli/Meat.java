package com.yearup.deli;

public class Meat extends Topping{
    private boolean extra;
    private int size;

    public Meat(String type, int sandwichSize, Sandwich sandwich) {
        super(type, sandwichSize, sandwich);
        this.extra = false;
        this.size = sandwich.getSandwichSize();
    }

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
                System.out.println("Invalid input. ");
        }
                if (extra) {
                    price += calculateMeatPrice();
                }

          return price;
    }
    public double calculateMeatPrice() {
            double extraMeatPrice = 0.0;
            switch (sandwichSize) {
                case 4: extraMeatPrice = .50;
                break;
                case 8: extraMeatPrice = 1.00;
                break;
                case 12: extraMeatPrice = 1.50;
            }
            return extraMeatPrice;
        }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
