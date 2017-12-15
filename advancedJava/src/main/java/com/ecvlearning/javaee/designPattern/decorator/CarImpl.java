package com.ecvlearning.javaee.designPattern.decorator;


public class CarImpl implements Car{
    @Override
    public void drive() {
        System.out.println("Driving car.");
    }
}
