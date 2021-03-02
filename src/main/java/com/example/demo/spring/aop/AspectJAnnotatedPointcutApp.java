package com.example.demo.spring.aop;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lidongliang
 * create at: 2021/2/7  4:31 下午
 */
@Configurable
@EnableAspectJAutoProxy
public class AspectJAnnotatedPointcutApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AspectJAnnotatedPointcutApp.class, AspectConfiguration.class);
        applicationContext.refresh();

        AspectJAnnotatedPointcutApp contextBean = applicationContext.getBean(AspectJAnnotatedPointcutApp.class);
        contextBean.executed();

    }

    public void executed() {
        System.out.println("executed() ....");
    }
}
