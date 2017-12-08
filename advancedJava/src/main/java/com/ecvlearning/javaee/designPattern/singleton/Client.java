package com.ecvlearning.javaee.designPattern.singleton;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args){
        SingleInstance si = SingleInstance.getSi();
        si.print();
        si.name = "abc";
        System.out.println(si.name);

        si = null;
//        si.print();

        si = SingleInstance.getSi();
        si.print();

        final Map map = new HashMap();
        map.put("1","1");
    }
}
