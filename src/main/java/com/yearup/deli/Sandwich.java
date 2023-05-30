package com.yearup.deli;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String size;
    private String bread;
    private List<String> toppings;
    private List<String> sauces;
    private boolean toasted;

    public Sandwich(String size, String bread) {
        this.size = size;
        this.bread = bread;
        toppings = new ArrayList<>();
        sauces = new ArrayList<>();
        toasted = false;
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

    }
}
