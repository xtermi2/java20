package com.github.xtermi2.java20.jep437structuredconcurrency;

import jdk.incubator.concurrent.StructuredTaskScope;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StructuredConcurrency {

    public record Response(String user, String order) {
    }

    Response executeStructuredConcurrently() throws ExecutionException, InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Future<String> user = scope.fork(() -> findUser());
            Future<String> order = scope.fork(() -> fetchOrder());

            scope.join();           // Join both forks
            scope.throwIfFailed();  // ... and propagate errors

            // Here, both forks have succeeded, so compose their results
            return new Response(user.resultNow(), order.resultNow());
        }
    }

    Response executeClassicConcurrently() throws ExecutionException, InterruptedException {
        try (var exec = Executors.newCachedThreadPool()) {
            Future<String> user = exec.submit(() -> findUser());
            Future<String> order = exec.submit(() -> fetchOrder());
            String theUser = user.get();   // Join findUser
            String theOrder = order.get();  // Join fetchOrder
            return new Response(theUser, theOrder);
        }
    }

    private String findUser() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(1));
        return "User 1";
    }

    private String fetchOrder() throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(2));
        return "Order 1";
    }
}
