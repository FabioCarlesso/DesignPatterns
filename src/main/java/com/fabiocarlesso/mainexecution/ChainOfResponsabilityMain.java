package com.fabiocarlesso.mainexecution;

import com.fabiocarlesso.chainofresponsibility.middleware.Middleware;
import com.fabiocarlesso.chainofresponsibility.middleware.RoleCheckMiddleware;
import com.fabiocarlesso.chainofresponsibility.middleware.ThrottlingMiddleware;
import com.fabiocarlesso.chainofresponsibility.middleware.UserExistsMiddleware;
import com.fabiocarlesso.chainofresponsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChainOfResponsabilityMain {
    public static void chainOfResponsabilityMain() throws IOException {
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
}
