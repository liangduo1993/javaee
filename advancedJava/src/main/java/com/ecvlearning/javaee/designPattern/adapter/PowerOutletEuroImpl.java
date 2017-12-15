package com.ecvlearning.javaee.designPattern.adapter;

public class PowerOutletEuroImpl implements PowerOutletEuro{
    @Override
    public boolean connect() {
        System.out.println("Euro power outlet connected!");
        return true;
    }
}
