package org.geekbang.thinking.in.spring.bean.test1.aop;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPBeanTest {
    public static void main(String[] args)  {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        BeanA bean = context.getBean(BeanA.class);
        bean.test2();

        bean.test();
    }
}
