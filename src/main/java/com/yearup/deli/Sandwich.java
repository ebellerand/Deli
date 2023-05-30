package com.yearup.deli;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product implements IPrice {
    private int size;
    private String breadType;
    private List<Topping> toppings;
    private List<String> sauces;
    private boolean toasted;


    public Sandwich(String type, int size, String breadType, boolean toasted) {
        super(type);
        this.size = size;
        this.breadType = breadType;
        this.toppings = toppings;
        this.sauces = new ArrayList<>();
        this.toasted = toasted;

    }

    public int getSize() {
        return size;
    }

    public String getBread() {
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
}