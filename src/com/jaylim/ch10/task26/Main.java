package com.jaylim.ch10.task26;

import java.net.PasswordAuthentication;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static final Random rand = new Random();

    public static void main(String[] args) throws Exception {
        /*CompletableFuture<Integer> t = repeat(
                () -> rand.nextInt(32),
                (integer) -> integer == 7);*/
        CompletableFuture<PasswordAuthentication> t = repeat(
                new Supplier<PasswordAuthentication>() {
                    @Override
                    public PasswordAuthentication get() {
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Input login: ");
                        String user = scanner.nextLine();
                        System.out.println("Input password: ");
                        String pass = scanner.nextLine();
                        PasswordAuthentication passwordAuthentication = new PasswordAuthentication(user, pass.toCharArray());
                        return passwordAuthentication;
                    }
                },

                new Predicate<PasswordAuthentication>() {
                    @Override
                    public boolean test(PasswordAuthentication passwordAuthentication) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }

                        return new String(passwordAuthentication.getPassword()).equals("secret");
                    }
                }
        );
    }

    public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
        BlockingQueue<T> queue = new ArrayBlockingQueue<>(1);
        CompletableFuture<T> future = new CompletableFuture<>();
        Runnable actionTask = new Runnable() {
            @Override
            public void run() {
                try {
                    while (!future.isDone()) {
                        queue.put(action.get());
                    }
                } catch (InterruptedException ex) {
                    System.out.println("Action task is interrupted.");
                }
            }
        };
        Runnable testTask = new Runnable() {
            @Override
            public void run() {
                T obj = null;
                try {
                    obj = queue.take();
                    while (!until.test(obj)) {
                        obj = queue.take();
                    }
                    future.complete(obj);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
                System.out.println("Is done!");
            }
        };
        new Thread(actionTask).start();
        new Thread(testTask).start();

        return future;
    }
}