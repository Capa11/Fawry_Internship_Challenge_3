package data;

import data.interfaces.Shippable;

public class TV extends Product implements Shippable {
    public TV(String name, int price, int quantity, int weight) {
        super(name, price, quantity, weight);
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
