package org.geekbang.thinking.in.spring.bean.test1.lookup;


import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AnnotationConfig {
    @Bean
    public LazyInitTargetSourceCreator lazyInitTargetSourceCreator(){
        return new LazyInitTargetSourceCreator();
    }

}
