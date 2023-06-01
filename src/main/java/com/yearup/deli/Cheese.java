package com.yearup.deli;

public class Cheese extends Topping {
    private boolean extra;

    public Cheese(String type, int sandwichSize, Sandwich sandwich) {
        super(type, sandwichSize, sandwich);
        this.extra = false;
        this.sandwichSize = sandwich.getSandwichSize();
    }

    @Override
    public double getPrice() {
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
                System.out.println("Invalid input. ");

        }
        if (extra) {
            price += calculateExtraCheesePrice();

    }
    return price;
}

    public boolean isExtraOrNot() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    private double calculateExtraCheesePrice(){
        double extraCheesePrice = 0.0;
        switch (sandwichSize) {
            case 4:
                extraCheesePrice = .30;
            break;
            case 8:
                extraCheesePrice = .60;
            break;
            case 12:
                extraCheesePrice += .90;
            break;
            default:
                System.out.println("Invalid entry. ");
        } return extraCheesePrice;
    }


}
