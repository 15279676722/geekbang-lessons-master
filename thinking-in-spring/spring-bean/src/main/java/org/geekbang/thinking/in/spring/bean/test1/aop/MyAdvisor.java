package org.geekbang.thinking.in.spring.bean.test1.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

@Component
public class MyAdvisor implements PointcutAdvisor {
    @Override
    public Pointcut getPointcut() {
        Pointcut pointcut = new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return clazz -> true;
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {
                    @Override
                    public boolean matches(Method method, Class<?> targetClass) {
                        return Objects.equals("test", method.getName());
                    }

                    @Override
                    public boolean isRuntime() {
                        return false;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> targetClass, Object... args) {
                        return true;
                    }
                };
            }
        };
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return new MyInterceptor();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
