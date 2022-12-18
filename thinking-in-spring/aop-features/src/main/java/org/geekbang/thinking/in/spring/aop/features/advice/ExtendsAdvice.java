package org.geekbang.thinking.in.spring.aop.features.advice;

import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class ExtendsAdvice implements Pointcut, Advice {
    public void sys(Method method, Object[] args, @Nullable Object target) {
        System.out.println(method.getName());
        System.out.println(args);
        System.out.println(target);
    }


    @Override
    public ClassFilter getClassFilter() {
        return ClassFilter.TRUE;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return null;
    }

}
