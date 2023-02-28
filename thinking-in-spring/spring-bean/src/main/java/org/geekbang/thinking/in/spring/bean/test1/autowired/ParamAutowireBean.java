package org.geekbang.thinking.in.spring.bean.test1.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParamAutowireBean {
    private BeanB beanB;

    public  ParamAutowireBean(@Autowired BeanB beanB) {
        this.beanB = beanB;
    }

    public BeanB getBeanB() {
        return beanB;
    }
}
