package com.ecvlearning.javaee.designPattern.facade;

public class CaoZong {
    public static void main(String[] args){
        Alarm a = new Alarm();
        a.start();
        a.shutdown();
    }
}
