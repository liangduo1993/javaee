package com.ecvlearning.javaee.multithreading;

import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Thread work  = new Worker();
//        work.start();
//        work.join();
//
//        Thread work2  = new Worker();
//        work2.start();
//        work2.join();
//
//        System.out.println("Gotcha!");
//
//        Runnable userRequest = new UserRequest();
//        Thread userRequestThread = new Thread(userRequest);
//        Thread userRequestThread2 = new Thread(userRequest);
//        userRequestThread.start();
//        userRequestThread2.start();

        Callable response = new Response();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future<String> future = executor.submit(response);
        System.out.println(future.get());
    }
}
