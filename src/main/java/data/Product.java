package data;

import lombok.*;

import java.util.Date;

public abstract class Product {
    @Getter
    @Setter
    protected String name;
    @Getter
    @Setter
    protected double price;
    @Getter
    @Setter
    protected int quantity;
    protected Date expiryDate;
    protected double weight;

    protected boolean isExpirable=false;
    protected boolean isShippable=false;

    //notExpirable - notShippable
    protected Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //Expirable
    protected Product(String name, double price, int quantity, Date expiryDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        isExpirable=true;
    }

    //Shippable
    public Product(String name, double price, int quantity, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        isShippable=true;
    }
    //Shippable - Expirable
    public Product(String name, double price, int quantity, Date expiryDate, double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.weight = weight;
        isShippable=true;
        isExpirable=true;
    }

}
