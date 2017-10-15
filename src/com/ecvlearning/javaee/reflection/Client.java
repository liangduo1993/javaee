package com.ecvlearning.javaee.reflection;

public class Client {

    public static void main(String[] ars) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        ReflectionExample re = new ReflectionExample();
//        re.test();

        String cretiria = "c";
        String className = "";
        if("c".equals(cretiria)){
            className = "ReflectionExample";
        }else{
            className = "ReflectionExample2";
        }

        Class cls = Class.forName(className);
        ReflectionInterface re = (ReflectionInterface) cls.newInstance();
        re.test();



    }
}
