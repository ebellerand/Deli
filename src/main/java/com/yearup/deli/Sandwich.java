package com.yearup.deli;

import java.util.ArrayList;
import java.util.List;

public abstract class Sandwich extends Product implements IPrice{
    private String size;
    private String bread;
    private List<String> toppings;
    private List<String> sauces;
    private boolean toasted;

    public Sandwich(String type, String size, String bread, List<String> toppings, List<String> sauces, boolean toasted) {
        super(type);
        this.size = size;
        this.bread = bread;
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.toasted = false;
    }

    public String getSize() {
        return size;
    }

    public String getBread() {
        return bread;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public boolean isToasted() {
        return toasted;
    }

    private static void addSandwich() {
        System.out.println("Select your bread: ");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rey");
        System.out.println("4) Wrap");
        int breadChoice;
    }
}
