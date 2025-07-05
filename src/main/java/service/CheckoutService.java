package service;
import data.Customer;
import data.interfaces.Expirable;
import data.Product;
import data.interfaces.Shippable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CheckoutService {

    private final ShippingService shippingService = new ShippingService();

    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }
        double subtotal = 0.0;
        Map<Shippable, Integer> itemsToShip = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product instanceof Expirable) {
                if (((Expirable) product).getExpiryDate().before(new Date())) {
                    throw new IllegalStateException(product.getName() + " is expired.");
                }
            }
            if (quantity > product.getQuantity()) {
                throw new IllegalStateException("Insufficient stock for: " + product.getName());
            }
            subtotal += product.getPrice() * quantity;

            if (product instanceof Shippable) {
                itemsToShip.put((Shippable) product, quantity);
            }
        }
        if (!itemsToShip.isEmpty()) {
            shippingService.ship(itemsToShip);
        }

        double total = subtotal + customer.getShippingFee();
        if (customer.getBalance() < total) {
            throw new IllegalStateException("Insufficient balance.");
        }
        customer.pay(total);
        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double lineTotal = product.getPrice() * quantity;

            System.out.printf("%dx %-12s %.0f%n", quantity, product.getName(), lineTotal);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f%n", subtotal);
        System.out.printf("Shipping         %.0f%n", customer.getShippingFee());
        System.out.printf("Amount           %.0f%n", total);
        System.out.printf("Balance after    %.0f%n", customer.getBalance());


    }
}
