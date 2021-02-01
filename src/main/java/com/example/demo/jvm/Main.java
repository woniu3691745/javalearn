package com.example.demo.jvm;

import com.example.demo.jvm.objecthead.A;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

/**
 * @author lidongliang
 * create at: 2020/8/27  10:45 上午
 */
public class Main {

    //-Xms30m -Xmx30m -Xss1m -XX:MaxMetaspaceSize=30m
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        String str = "123123123123123123123123123123123123123123123123123123";
//        while (true) {
//            str = str + "123123123123123123123123123123123123123";
////            System.out.println("str = " + str);
//        }

        Main main = new Main();
        List<String> list = new ArrayList<>();
        main.m1(list);
        list.forEach(System.out::print);


        StampedLock stampedLock = new StampedLock();


    }

    public void m1(List<String> list) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Annotation[] annotations = A.class.getDeclaredAnnotations();
//        A o = (A)Class.forName("org.springframework.stereotype.Service.A").newInstance();

        Class<?> aClass = Class.forName(A.class.getName());
        Service annotation = aClass.getAnnotation(Service.class);
        String value = annotation.value();
        System.out.println(value);
//        System.out.println(Arrays.asList(annotations).toString());

        list.add("1-");
        list.add("1-");
        list.add("1");

    }





}
