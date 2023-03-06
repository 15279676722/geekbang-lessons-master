package org.geekbang.thinking.in.spring.bean.test1.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJConfig {
    @Pointcut("execution(public void org.geekbang.thinking.in.spring.bean.test1.aop.BeanA.*(..))") // 匹配 Join Point
    public void aspectJ(){
        System.out.println("@Pointcut at any public method.");
    }

    @Before("aspectJ()")
    public void before(){
        System.out.println("before");
    }

    @After("aspectJ()")
    public void after(){
        System.out.println("after");
    }
}
