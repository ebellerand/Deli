package com.yearup.deli;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Order implements IPrice{
   private List<Product>products;
   private double total;

    public Order() {
        this.total = total;
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        double total = 0.0;
        for(int i=0; i<products.size(); i++){
            if (products.get(i)instanceof Sandwich){
                total += products.get(i).getPrice();
            }
            if(products.get(i)instanceof Drink){
                total += products.get(i).getPrice();
            }
            if(products.get(i)instanceof Chips){
                total += products.get(i).getPrice();
            }
        }
        return total;
    }

    public void addProduct(Product product){
        products.add(product);
        total += product.getPrice();
    }

    @Override
    public double getPrice() {
        return getPrice();
    }
}
