package com.ecvlearning.javaee.designPattern.adapter;

public class PowerOutletUSImpl implements PowerOutletUS, PowerOutletEuro {
    @Override
    public boolean plugin() {
        System.out.println("US power outlet connected!");
        return true;
    }

    @Override
    public boolean connect() {
        this.plugin();
        return true;
    }
}
