package com.ecvlearning.javaee.designPattern.singleton;

public class LazySingleInstance {
    private static volatile SingleInstance si = null;
    private LazySingleInstance(){
        //empty constructor
    }
}
