package org.geekbang.thinking.in.spring.bean.test1.aop;


import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
//@EnableAspectJAutoProxy
public class AnnotationConfig {
    @Bean
    public MyBeanNameAutoProxyCreator beanNameAutoProxyCreator(){
        MyBeanNameAutoProxyCreator beanNameAutoProxyCreator = new MyBeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("beanA");
        beanNameAutoProxyCreator.setInterceptorNames("myInterceptor");
        return beanNameAutoProxyCreator;
    }


}
