package com.example.demo.jvm.objecthead;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author lidongliang
 * create at: 2020/8/31  11:59 上午
 */
@Slf4j(topic = "lidingliang")
public class Main {

    static A a = new A();

    public static void main(String[] args) {
        synchronized (A.class) {
            System.out.println(1);
        }
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());
//        System.out.println(Integer.toHexString(a.hashCode()));
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        log.info(ClassLayout.parseInstance(a).toPrintable());
        log.info(Integer.toHexString(a.hashCode()));
        System.out.println(">>> " + a.hashCode());
        log.info(ClassLayout.parseInstance(a).toPrintable());
    }
}
