package org.geekbang.thinking.in.spring.bean.test1.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPBeanTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        BeanA bean = context.getBean(BeanA.class);
    }
}
