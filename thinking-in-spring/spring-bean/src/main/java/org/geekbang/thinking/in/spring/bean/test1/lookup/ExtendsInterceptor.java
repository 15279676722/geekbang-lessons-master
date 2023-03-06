package org.geekbang.thinking.in.spring.bean.test1.lookup;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class ExtendsInterceptor implements MethodInterceptor {



    public ExtendsInterceptor() {

    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("yangqiang");
        return methodInvocation.proceed();
    }
}
