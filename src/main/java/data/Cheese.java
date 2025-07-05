package data;

import data.interfaces.Expirable;
import data.interfaces.Shippable;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
public class Cheese extends Product implements Shippable , Expirable {
    public Cheese(String name, int price, int quantity, int weight, Date expiryDate) {
        super(name, price, quantity, expiryDate, weight);
    }

    @Override
    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public int getWeight() {
        return weight;
    }
    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Override
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
