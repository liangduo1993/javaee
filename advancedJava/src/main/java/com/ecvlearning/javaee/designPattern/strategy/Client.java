package com.ecvlearning.javaee.designPattern.strategy;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args){
        Sort sort = SortAlgrithmFactory.getAlgorithm("quicksort");
        sort.sort(new ArrayList<>());
    }
}
