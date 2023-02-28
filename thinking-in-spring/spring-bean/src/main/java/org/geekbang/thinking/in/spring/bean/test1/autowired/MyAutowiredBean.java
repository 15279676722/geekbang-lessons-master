package org.geekbang.thinking.in.spring.bean.test1.autowired;

import org.springframework.stereotype.Component;

@Component
public class MyAutowiredBean {
    @MyAutowired
    private BeanB beanB;

    public BeanB getBeanB() {
        return beanB;
    }
}
