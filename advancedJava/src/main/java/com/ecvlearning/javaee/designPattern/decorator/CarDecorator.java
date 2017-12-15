package com.ecvlearning.javaee.designPattern.decorator;

public class CarDecorator implements Car{
    Car car  = new CarImpl();

    @Override
    public void drive() {
        car.drive();
        fly();
    }

    private void fly(){
        System.out.println("I believe I can fly.");
    }
}
