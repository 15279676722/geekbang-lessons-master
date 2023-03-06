package org.geekbang.thinking.in.spring.bean.test1.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
@Component
public class LookUpBean {

    private BeanB beanB;


    @PreDestroy
    public void destroy(){
        MyMergeBeanPostProcessor.print();
    }
    @PreDestroy
    public void destroy2(){
        MyMergeBeanPostProcessor.print();
    }
    @PreDestroy
    public void destroy3(){
        MyMergeBeanPostProcessor.print();
    }

    @Autowired
    public void setBeanB(BeanB beanB) {
        this.beanB = beanB;
    }

    public BeanB getBeanB() {
        return beanB;
    }
}
