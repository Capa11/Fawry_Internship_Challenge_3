package data;

import data.interfaces.Expirable;
import data.interfaces.Shippable;

import java.util.Date;
public class Biscuits extends Product implements Shippable, Expirable {

    public Biscuits(String name, int price, int quantity, Date expiryDate, int weight) {
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
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
