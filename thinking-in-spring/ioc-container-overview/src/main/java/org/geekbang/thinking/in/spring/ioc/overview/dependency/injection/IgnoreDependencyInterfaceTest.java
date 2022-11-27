package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.overview.domain.SuperUser;
import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.*;

@ImportResource("classpath:/META-INF/dependency-lookup-context.xml")
@ComponentScan(value = "org.geekbang.thinking.in.spring.ioc.overview.dependency.injection")
public class IgnoreDependencyInterfaceTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(IgnoreDependencyInterfaceTest.class);


        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        beanFactory.ignoreDependencyInterface(IgnoreDependencyImpl.class);
//        beanFactory.ignoreDependencyType(User.class);


        context.refresh();

        System.out.println(beanFactory.getBean(IgnoreDependencyService.class));

    }

    @Bean(autowire = Autowire.BY_TYPE)
    public IgnoreDependencyService ignoreDependencyService(){
        return new IgnoreDependencyImpl();
    }



}
