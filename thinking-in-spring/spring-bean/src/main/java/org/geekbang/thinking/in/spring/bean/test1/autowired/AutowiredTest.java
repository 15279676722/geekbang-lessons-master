package org.geekbang.thinking.in.spring.bean.test1.autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @create 2022-05-24 20:16
 */
public class AutowiredTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AnnotationConfig.class);
		context.register(AutowiredTest.class);
		ConstructorAutowireBean constructorAutowireBean = context.getBean(ConstructorAutowireBean.class);
		System.out.println(constructorAutowireBean.getBeanB());

		SetFieldAutowireBean setFieldAutowireBean = context.getBean(SetFieldAutowireBean.class);
		System.out.println(setFieldAutowireBean.getBeanB());

		ParamAutowireBean paramAutowireBean = context.getBean(ParamAutowireBean.class);
		System.out.println(paramAutowireBean.getBeanB());

		FieldAutowireBean fieldAutowireBean = context.getBean(FieldAutowireBean.class);
		System.out.println(fieldAutowireBean.getBeanB());

		MyAutowiredBean myAutowiredBean = context.getBean(MyAutowiredBean.class);
		System.out.println(myAutowiredBean.getBeanB());
	}



}
