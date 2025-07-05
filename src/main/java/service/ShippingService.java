package service;

import data.interfaces.Shippable;

import java.util.Map;

public class ShippingService {

    public void ship(Map<Shippable, Integer> items) {
        if (items.isEmpty()) {
            return;
        }

        double totalWeight = 0.0;

        System.out.println("\n** Shipment notice **");

        for (Map.Entry<Shippable, Integer> entry : items.entrySet()) {
            Shippable item = entry.getKey();
            int quantity = entry.getValue();
            double itemTotalWeight = item.getWeight() * quantity;
            totalWeight += itemTotalWeight;

            System.out.printf("%dx %-12s %.0fg%n", quantity, item.getName(), itemTotalWeight);
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight / 1000.0);
    }
}
