package org.geekbang.thinking.in.spring.bean.test1.bean;

import org.geekbang.thinking.in.spring.bean.test1.lookup.AnnotationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @create 2022-05-24 20:16
 */
public class BeanTest {

	public static void main(String[] args) {
		ApplicationContext context =
				new AnnotationConfigApplicationContext(AnnotationConfig.class);
		SetterBean myService = context.getBean(SetterBean.class);
		System.out.println(myService.getService());

		SetterBean.ServiceB bean = context.getBean(SetterBean.ServiceB.class);
		System.out.println(bean);
		UserService userService = context.getBean(UserService.class);

		userService.getUserName();
	}


}
