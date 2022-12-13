package org.geekbang.thinking.in.spring.aop.features.transactional;

import org.geekbang.thinking.in.spring.aop.features.condition.MyCondition;
import org.geekbang.thinking.in.spring.aop.features.transactional.bean.TransactionalImpl;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(proxyTargetClass = true)
@Configuration
@Conditional(value = MyCondition.class)
@ComponentScan(value = "org.geekbang.thinking.in.spring.aop.features.transactional.bean",
        nameGenerator = MyBeanNameGenerator.class
)
@PropertySource(value = "classpath:application.properties",name = "test3",encoding = "UTF-8",ignoreResourceNotFound = true)
@Import(ImportBean.class)
@ImportResource("classpath:/META-INF/spring-bean-import-source.xml")
public class TransactionalDemo {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TransactionalDemo.class);
        context.refresh();
        TransactionalImpl bean = context.getBean(TransactionalImpl.class);
        bean.publicMethod();
        context.close();
    }

    @Bean
    @Conditional(value = MyCondition.class)
    public TransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/cloud2021");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }




}
