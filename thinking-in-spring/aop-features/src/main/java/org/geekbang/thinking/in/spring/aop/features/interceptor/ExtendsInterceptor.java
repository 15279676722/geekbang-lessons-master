package org.geekbang.thinking.in.spring.aop.features.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.geekbang.thinking.in.spring.aop.features.advice.ExtendsAdvice;
import org.springframework.util.Assert;

public class ExtendsInterceptor implements MethodInterceptor {
    private ExtendsAdvice advice;

    public ExtendsInterceptor(ExtendsAdvice advice) {
        Assert.notNull(advice, "Advice must not be null");
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        this.advice.sys(methodInvocation.getMethod(),methodInvocation.getArguments(),methodInvocation.getThis());
        return methodInvocation.proceed();
    }
}
