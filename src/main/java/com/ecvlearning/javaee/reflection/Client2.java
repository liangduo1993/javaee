package com.ecvlearning.javaee.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Client2 {
    public static void main(String[] args) throws Exception {
        String className = args[0];

        Class cls = Class.forName(className);
        ReflectionInterface re = (ReflectionInterface) cls.newInstance();
        re.test();

        System.out.println(cls.getName());

        System.out.println();
        Method[] methods = cls.getMethods();
        for(Method method : methods){
            if(method.getName().startsWith("test")){
                method.invoke(cls.newInstance());
//                System.out.println(method.getName());
            }
//            System.out.println(method.getName());
        }

        System.out.println();
        Field[] fields = cls.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field.getName());
        }

    }
}
