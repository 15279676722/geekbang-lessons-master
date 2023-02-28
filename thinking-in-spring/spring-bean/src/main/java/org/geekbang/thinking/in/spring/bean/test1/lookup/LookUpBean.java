package org.geekbang.thinking.in.spring.bean.test1.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class LookUpBean {
    @Lookup
    public BeanB beanB(){
        return null;
    }

    public void print(){
        System.out.println(this);
        System.out.println(beanB());
    }
}
