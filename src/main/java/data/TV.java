package data;

import data.interfaces.Shippable;

public class TV extends Product implements Shippable {
    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity, weight);
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
