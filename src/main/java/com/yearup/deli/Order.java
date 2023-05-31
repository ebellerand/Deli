package com.yearup.deli;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Order implements IPrice{
   private List<Product>products;
   private double total;

    public Order(double total) {
        this.total = total;
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public double getPrice() {
        return total;
    }
}
