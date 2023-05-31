package com.yearup.deli;

public class Cheese extends Topping{
    private boolean extraOrNot;
    public Cheese(String type, int sandwichSize, Sandwich sandwich) {
        super(type, sandwichSize, sandwich);
        this.extraOrNot = false;
        this.sandwichSize = sandwich.getSandwichSize();
    }
    @Override
    public double getPrice(){
        double price = 0.0;
        switch (sandwichSize) {
            case 4:
                price = .75;
                break;

            case 8:
                price = 1.50;
                break;
            case 12:
                price = 2.25;
                break;

            default:
                System.out.println("Invalid sandwich price. ");

        }  return price;

    }

    public boolean isExtraOrNot() {
        return extraOrNot;
    }

    public void setExtraOrNot(boolean extraOrNot) {
        this.extraOrNot = extraOrNot;
    }
}
