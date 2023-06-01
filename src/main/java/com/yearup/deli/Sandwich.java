package com.yearup.deli;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product implements IPrice {
    int sandwichSize;
    private String breadType;
    private List<Topping> toppings;
    private List<String> sauces;
    private boolean toasted;


    public Sandwich(String type, int size, String breadType, boolean toasted) {
        super(type);
        this.sandwichSize = size;
        this.breadType = breadType;
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.toasted = toasted;

    }

    public int getSandwichSize() {
        return sandwichSize;
    }

    public String getBreadType() {
        return breadType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public double getPrice() {
        return price;
    }
}