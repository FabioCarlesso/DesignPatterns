package com.fabiocarlesso.mainexecution;

import com.fabiocarlesso.chainofresponsibility.order.Order;
import com.fabiocarlesso.strategy.PayByCreditCard;
import com.fabiocarlesso.strategy.PayByPayPal;
import com.fabiocarlesso.strategy.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class StrategyMain {
    public static void strategyMain() throws IOException {
        Map<Integer, Integer> priceOnProducts = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Order order = new Order();
        PayStrategy strategy = null;

        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);

        while (!order.isClosed()) {
            int cost;

            String continueChoice;
            do {
                System.out.println("Please, select a product:");
                System.out.println("1 - Mother board");
                System.out.println("2 - CPU");
                System.out.println("3 - HDD");
                System.out.println("4 - Memory");
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Please, select a payment method:");
                System.out.println("1 - PalPay");
                System.out.println("2 - Credit Card");
                String paymentMethod = reader.readLine();

                // Client creates different strategies based on input from user,
                // application configuration, etc.
                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }
            }

            // Order object delegates gathering payment data to strategy object,
            // since only strategies know what data they need to process a
            // payment.
            order.processOrder(strategy);

            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                // Finally, strategy handles the payment.
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();
            }
        }
    }
}
