package org.geekbang.thinking.in.spring.bean.test1.lookup;


import com.mysql.cj.jdbc.MysqlDataSource;
import org.geekbang.thinking.in.spring.bean.test1.lookup.LazyInitTargetSourceCreator;
import org.geekbang.thinking.in.spring.bean.test1.lookup.LookUpBean;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AnnotationConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        // 创建jdbcTemplate模板对象,设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }
    @Bean
    public LazyInitTargetSourceCreator lazyInitTargetSourceCreator(){
        return new LazyInitTargetSourceCreator();
    }




    @Bean
    public BeanNameAutoProxyCreator nameAutoProxyCreator(){
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("beanB");
        beanNameAutoProxyCreator.setInterceptorNames("extendsInterceptor");
        return beanNameAutoProxyCreator;
    }





}
