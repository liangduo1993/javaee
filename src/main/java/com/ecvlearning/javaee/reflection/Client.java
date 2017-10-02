package com.ecvlearning.javaee.reflection;

public class Client {

    public static void main(String[] ars) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        ReflectionExample re = new ReflectionExample();
//        re.test();

        String cretiria = "c";
        String className = "";
        if("c".equals(cretiria)){
            className = "com.ecvlearning.javaee.reflection.ReflectionExample";
        }else{
            className = "com.ecvlearning.javaee.reflection.ReflectionExample2";
        }

        Class cls = Class.forName(className);
        ReflectionInterface re = (ReflectionInterface) cls.newInstance();
        re.test();



    }
}
