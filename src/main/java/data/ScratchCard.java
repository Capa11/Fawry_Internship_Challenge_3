package data;

import data.interfaces.Expirable;

import java.util.Date;

public class ScratchCard extends Product implements Expirable{
    public ScratchCard(String name, double price, int quantity, Date expiryDate) {
        super(name, price, quantity, expiryDate);
    }

    @Override
    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
