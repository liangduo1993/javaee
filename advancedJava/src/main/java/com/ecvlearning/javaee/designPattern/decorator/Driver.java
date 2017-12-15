package com.ecvlearning.javaee.designPattern.decorator;

public class Driver {
    public static void main(String[] args){
        Car car = new CarImpl();
        car.drive();

        car = new CarDecorator();
        car.drive();
    }
}
