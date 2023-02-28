package org.geekbang.thinking.in.spring.bean.test1.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 *
 * autowireCandidate = false 属性
 *     此bean不可被其他对象注入！
 *     防止NoUniqueBeanDefinitionException异常
 *     优先级很高阻止其他各种方式想注入这个bean都不行
 *     @Autowired :byName形式的注入 不行
 *     @Primary   :不行 注解失效
 *     @Qualifier :报错没有候选bean
 * @Primary 注解:
 *     优先注入该bean 只能出现一个@Primary 除非其他都被移除出候选项 也就是autowireCandidate = false
 *
 */
public class AnnotationConfig {

	@Bean
	public SetterBean.ServiceA serviceA(){
		return new SetterBean.ServiceA();
	}

	@Bean(autowireCandidate = false)
	public SetterBean.ServiceB serviceB(){
		return new SetterBean.ServiceB();
	}

    @Autowired
	private SetterBean.IService serviceB;


	@Bean
	public SetterBean setterBean(){
		SetterBean setterBean = new SetterBean();
		setterBean.setService(serviceB);
		return setterBean;
	}

	@Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
	public UserService userService(){
		return new UserService("libai");
	}
}
