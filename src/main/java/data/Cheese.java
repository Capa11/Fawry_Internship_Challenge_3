package data;

import data.interfaces.Expirable;
import data.interfaces.Shippable;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
public class Cheese extends Product implements Shippable , Expirable {
    public Cheese(String name, double price, int quantity, double weight, Date expiryDate) {
        super(name, price, quantity, expiryDate, weight);
    }

    @Override
    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
