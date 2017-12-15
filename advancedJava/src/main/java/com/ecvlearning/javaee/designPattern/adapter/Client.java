package com.ecvlearning.javaee.designPattern.adapter;

public class Client {
    public static void main(String[] args){
        PowerOutletEuro poe = new PowerOutletEuroImpl();
        PowerOutletEuro pou = new PowerOutletUSImpl();

        pou.connect();
    }
}
