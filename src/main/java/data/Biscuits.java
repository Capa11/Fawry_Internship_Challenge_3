package data;

import data.interfaces.Expirable;
import data.interfaces.Shippable;

import java.util.Date;
public class Biscuits extends Product implements Shippable, Expirable {

    public Biscuits(String name, double price, int quantity, Date expiryDate, double weight) {
        super(name, price, quantity, expiryDate, weight);
    }

    @Override
    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
