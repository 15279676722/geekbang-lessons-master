package org.geekbang.thinking.in.spring.bean.test1.lookup;

import org.geekbang.thinking.in.spring.bean.test1.annotation.MysqlResource;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public class LookUpBean implements DisposableBean {

    private BeanB beanB;

    private BeanB beanB2;

    private BeanB beanB3;

    @Autowired
    private BeanB beanB4;

    @MysqlResource(ids = "1")
    private User user;

    @MysqlResource(ids = {"1","2"})
    private List<User> userList;



    public BeanB getBeanB3() {
        return beanB3;
    }

    public BeanB getBeanB4() {
        return beanB4;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

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
    public void destroy(){
        MyMergeBeanPostProcessor.print();
    }
    @PreDestroy
    public void destroy2(){
        MyMergeBeanPostProcessor.print();
    }

    public void destroy3(){
        MyMergeBeanPostProcessor.print();
    }


    public void setBeanB(BeanB beanB) {
        this.beanB = beanB;
    }

    public void setBeanB2(BeanB beanB2) {
        this.beanB2 = beanB2;
    }

    public void setBeanB3(BeanB beanB3) {
        this.beanB3 = beanB3;
    }

    public void setBeanB4(BeanB beanB4) {
        this.beanB4 = beanB4;
    }
}
