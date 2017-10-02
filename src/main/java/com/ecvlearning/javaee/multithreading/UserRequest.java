package com.ecvlearning.javaee.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRequest implements Runnable{
    int count = 0;
    Map<String, Integer> sharedCount = new ConcurrentHashMap<>();
    Object lock = new Object();

    public UserRequest(){
        sharedCount.put("count",0);
    }

    @Override
    public void run() {
        //complicated logic
        //heavy calculation

        for(int i =0; i<10000000;i++){
            if(i%2 == 0){
                this.changeMapValue(1);
            }else{
                this.changeMapValue(0);
            }
//            this.increment();
//            synchronized (lock) {
//                count++;
//            }
        }
//        System.out.println(this.count);
        System.out.println(this.sharedCount.get("count"));
    }

    private void increment(){
        synchronized (lock) {
            count++;
        }
    }

    private void changeMapValue(int b){
//        int count = this.sharedCount.get("count");

        this.sharedCount.put("count",b);
    }
}
