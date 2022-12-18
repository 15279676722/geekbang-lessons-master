package org.geekbang.thinking.in.spring.aop.features.adaptor;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.geekbang.thinking.in.spring.aop.features.advice.ExtendsAdvice;
import org.geekbang.thinking.in.spring.aop.features.interceptor.ExtendsInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.adapter.AdvisorAdapter;

public class ExtendsAdaptor implements AdvisorAdapter {
    @Override
    public boolean supportsAdvice(Advice advice) {
        return advice instanceof ExtendsAdvice;
    }

    @Override
    public MethodInterceptor getInterceptor(Advisor advisor) {
        return new ExtendsInterceptor((ExtendsAdvice) advisor);
    }
}
