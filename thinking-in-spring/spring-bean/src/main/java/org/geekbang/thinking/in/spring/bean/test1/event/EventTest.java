package org.geekbang.thinking.in.spring.bean.test1.event;

import org.geekbang.thinking.in.spring.bean.test1.EventAnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventAnnotationConfig.class);


        System.out.println("end");
    }
}
