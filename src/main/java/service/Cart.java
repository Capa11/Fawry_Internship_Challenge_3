package service;

import data.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Product, Integer> products = new HashMap<Product, Integer>();
    public synchronized void add(Product product,int quantity) {
        if(quantity<=0)throw new IllegalArgumentException("quantity must be positive");
        if(product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Product quantity required more than quantity available");
        }
        product.setQuantity(product.getQuantity() - quantity);
        products.merge(product, quantity, Integer::sum);

    }
    public void remove(Product product) {
        products.remove(product);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

}
