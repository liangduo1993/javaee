package com.ecvlearning.javaee.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class Response implements Callable{
    int count = 0;

    @Override
    public Object call() throws Exception {
        ReentrantLock lock = new ReentrantLock();

        for(int i =0; i<100000000;i++){
            lock.tryLock();
            count++;
            lock.unlock();
        }
        return String.valueOf(count);
    }
}
