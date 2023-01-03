package org.geekbang.thinking.in.spring.aop.features;

import org.geekbang.thinking.in.spring.aop.features.adaptor.ExtendsAdaptor;
import org.geekbang.thinking.in.spring.aop.features.interceptor.ExtendsInterceptor;
import org.geekbang.thinking.in.spring.aop.features.transactional.TransactionalDemo;
import org.geekbang.thinking.in.spring.aop.features.transactional.bean.TransactionalImpl;
import org.geekbang.thinking.in.spring.aop.features.transactional.service.AccountService;
import org.springframework.aop.framework.adapter.AdvisorAdapterRegistrationManager;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = {TransactionalImpl.class, ExtendsInterceptor.class})
public class MyAdviceExtendsDemo {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyAdviceExtendsDemo.class, ExtendsAdaptor.class);
        context.refresh();
        TransactionalImpl bean = context.getBean(TransactionalImpl.class);
        bean.publicMethod();

        context.close();
    }

    public void test() {
        System.out.println("yangqiang");
    }

    @Bean
    public AdvisorAdapterRegistrationManager advisorAdapterRegistrationManager() {
        return new AdvisorAdapterRegistrationManager();
    }

    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("transactionalImpl");
        beanNameAutoProxyCreator.setInterceptorNames("extendsInterceptor");
        return beanNameAutoProxyCreator;
    }


}
