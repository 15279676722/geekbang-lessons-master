package org.geekbang.thinking.in.spring.bean.test1.lookup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LookUpTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        LookUpBean bean = context.getBean(LookUpBean.class);

        context.close();
    }
}
