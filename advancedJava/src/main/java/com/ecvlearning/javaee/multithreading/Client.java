package com.ecvlearning.javaee.multithreading;

import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //Synchronize
//        Runnable userRequest = new UserRequest(true);
//        Thread userRequestThread = new Thread(userRequest);
//        Thread userRequestThread2 = new Thread(userRequest);
//        userRequestThread.start();
//        userRequestThread2.start();
//
//        userRequestThread.join();
//        userRequestThread2.join();
//
//        System.out.println(((UserRequest)userRequest).count);

        //Callable example
//        Callable response = new Response();
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        Future<String> future = executor.submit(response);
//        System.out.println(future.get());
//        executor.shutdown();

        //dead lock
        final DeadLockRunner deadLockRunner = new DeadLockRunner(true);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    deadLockRunner.firstThread();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    deadLockRunner.secondThread();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        deadLockRunner.finished();
    }

}

