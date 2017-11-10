package com.ecvlearning.javaee.designPattern.adapter;

public class PowerOutletUSImpl implements PowerOutletUS {
    @Override
    public boolean plugin() {
        System.out.println("US power outlet connected!");
        return true;
    }
}
