package org.geekbang.thinking.in.spring.bean.test1.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LookUpBean {

    private BeanB beanB;

    @Autowired
    private BeanB beanB2;



    @Lookup
    BeanB beanB(){
        return null;
    }

    public void print(){
        System.out.println(this);
        System.out.println(beanB());
    }

    @Autowired
    public LookUpBean() {
    }

    @Autowired
    public LookUpBean(BeanB beanB) {
        this.beanB = beanB;
    }


    @Autowired
    public LookUpBean(BeanB beanB, BeanB beanB2) {
        this.beanB = beanB;
        this.beanB2 = beanB2;
    }

    public BeanB getBeanB() {
        return beanB;
    }

    public BeanB getBeanB2() {
        return beanB2;
    }

    @PostConstruct
    public void postConstruct(){
    }
    @PostConstruct
    public void postConstruct2(){
        MyMergeBeanPostProcessor.print();
    }
    @PostConstruct
    public void postConstruct3(){
        MyMergeBeanPostProcessor.print();
    }
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
}
