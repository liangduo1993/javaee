package com.ecvlearning.javaee.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericClass<T> {
    List<T> test(List<T> list){
        return null;
    }

    public static void main(String[] args){
        GenericClass<String> gt = new GenericClass<>();
//        List<Integer> list = gt.test(new ArrayList<>());
        List<String> list = gt.test(new ArrayList<>());
    }
}
