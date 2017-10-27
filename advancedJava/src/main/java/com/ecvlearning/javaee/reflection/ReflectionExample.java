package com.ecvlearning.javaee.reflection;

public class ReflectionExample implements ReflectionInterface{

    public int number = 0;
    public String str = "something";


    public void test(){
        System.out.println("The first reflection example.");
    }


    public void testX(){
        System.out.println("This is testX from reflection1");
    }

    public void testA(){
        System.out.println("This is testa from reflection1");
    }
}
