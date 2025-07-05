package org.example;

import data.Cheese;
import data.Customer;
import data.ScratchCard;
import data.TV;
import service.Cart;
import service.CheckoutService;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Cheese cheese = new Cheese("Cheese", 100, 5, 200, tomorrow());
        TV tv = new TV("TV", 300, 3, 15000);
        ScratchCard card = new ScratchCard("ScratchCard", 50, 10, nextWeek());
        Customer customer = new Customer("Ahmed", 20, 1000);
        CheckoutService checkoutService = new CheckoutService();

        System.out.println("\n--- Valid Checkout ---");
        Cart cart1 = new Cart();
        cart1.add(cheese, 2);
        cart1.add(tv, 1);
        cart1.add(card, 2);
        checkoutService.checkout(customer, cart1);

        System.out.println("\n--- Empty Cart ---");
        try {
            Cart cart2 = new Cart();
            checkoutService.checkout(customer, cart2);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        System.out.println("\n--- Expired Product ---");
        try {
            ScratchCard expiredCard = new ScratchCard("card2", 50, 2, yesterday());
            Cart cart3 = new Cart();
            cart3.add(expiredCard, 1);
            checkoutService.checkout(customer, cart3);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        System.out.println("\n--- Quantity Exceeds Stock ---");
        try {
            Cart cart4 = new Cart();
            cart4.add(tv, 10);
            checkoutService.checkout(customer, cart4);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        System.out.println("\n--- Insufficient Balance ---");
        try {
            Customer poorCustomer = new Customer("Ali", 21, 100);
            Cart cart5 = new Cart();
            cart5.add(tv, 1);
            checkoutService.checkout(poorCustomer, cart5);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }

    private static Date tomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    private static Date nextWeek() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 7);
        return cal.getTime();
    }

    private static Date yesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return cal.getTime();
    }
}
