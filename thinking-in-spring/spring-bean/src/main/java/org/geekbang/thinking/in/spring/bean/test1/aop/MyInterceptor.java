package org.geekbang.thinking.in.spring.bean.test1.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class MyInterceptor implements MethodInterceptor {
	@Override
	public Object invoke( MethodInvocation invocation) throws Throwable {
		System.out.println("MyInterceptor.invoke");
		return invocation.proceed();
	}
}
