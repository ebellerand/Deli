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
        this.breadType = bread;
        this.toppings = new ArrayList<>();
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

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    @Override
    public double getPrice() {
        double totalPrice = calculateBasePrice();
        totalPrice += calculateToppingsPrice();
        totalPrice += calculateToastedPrice();
        return totalPrice;
    }

    private double calculateBasePrice() {
        if (getSize().equals("4")) {
            return 5.50;
        } else if (getSize().equals("8")) {
            return 7.00;
        } else if (getSize().equals("12")) {
            return 8.50;
        } else {
            return 0.0;
        }
    }

    private double calculateToppingsPrice() {
        double totalPrice = 0.0;
        for (String topping : toppings) {
            if (topping.equals("meat")) {
                if (getSize().equals("4")) {
                    totalPrice += 1.00;
                } else if (getSize().equals("8")) {
                    totalPrice += 2.00;
                } else if (getSize().equals("12")) {
                    totalPrice += 3.00;
                }
            }
        } return totalPrice;
    }
            private double calculateToastedPrice() {
                return 0.0; // Not toasted
            }
    }