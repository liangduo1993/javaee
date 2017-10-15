package com.ecvlearning.javaee.multithreading;

public class Worker extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

}
