package com.fabiocarlesso;

import com.fabiocarlesso.command.invoker.TextFileOperationExecutor;
import com.fabiocarlesso.command.receiver.TextFile;
import com.fabiocarlesso.chainofresponsibility.middleware.Middleware;
import com.fabiocarlesso.chainofresponsibility.middleware.RoleCheckMiddleware;
import com.fabiocarlesso.chainofresponsibility.middleware.ThrottlingMiddleware;
import com.fabiocarlesso.chainofresponsibility.middleware.UserExistsMiddleware;
import com.fabiocarlesso.chainofresponsibility.order.Order;
import com.fabiocarlesso.strategy.PayByCreditCard;
import com.fabiocarlesso.strategy.PayByPayPal;
import com.fabiocarlesso.strategy.PayStrategy;
import com.fabiocarlesso.chainofresponsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DesignPatterns {
    public static void main(String[] args) throws IOException {
        //strategyMain();
        //chainOfResponsabilityMain();
        commandMain();
    }

    private static void commandMain() {
        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
        TextFile textFile = new TextFile("file1.txt");
        System.out.println(textFileOperationExecutor.executeOperation(textFile::open));
        System.out.println(textFileOperationExecutor.executeOperation(textFile::save));
        System.out.println(textFileOperationExecutor.executeOperation(textFile::copy));
        System.out.println(textFileOperationExecutor.executeOperation(textFile::paste));
    }

    private static void chainOfResponsabilityMain() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Server server;

        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // All checks are linked. Client can build various chains using the same
        // components.
        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );

        // Server gets a chain from client code.
        server.setMiddleware(middleware);

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }

    private static void strategyMain() throws IOException {
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
                System.out.print("Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card");
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