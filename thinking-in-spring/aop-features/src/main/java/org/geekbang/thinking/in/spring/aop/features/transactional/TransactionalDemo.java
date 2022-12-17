package org.geekbang.thinking.in.spring.aop.features.transactional;

import org.geekbang.thinking.in.spring.aop.features.condition.MyCondition;
import org.geekbang.thinking.in.spring.aop.features.transactional.bean.TransactionalImpl;
import org.geekbang.thinking.in.spring.aop.features.transactional.service.AccountService;
import org.geekbang.thinking.in.spring.aop.features.transactional.service.impl.AccountServiceAnnoFailImpl;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Map;

@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
@Configuration
@ComponentScan(value = "org.geekbang.thinking.in.spring.aop.features.transactional"
)
public class TransactionalDemo {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TransactionalDemo.class);
        context.refresh();
        AccountService accService = context.getBean("accountServiceAnnoFailImpl", AccountService.class);
        accService.accountBalance(1, 2, 500);
//        applyTransactional(beansOfType);
        context.close();
    }

    private static void applyTransactional(Map<String, AccountService> beansOfType) throws Exception {
        for(String key:beansOfType.keySet()){
            AccountService accountService = beansOfType.get(key);
            if (accountService instanceof AccountServiceAnnoFailImpl) {
                accountService.accountBalance(1, 2, 500);
            }
        }

    }


    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager platformTransactionManager) {
        return new TransactionTemplate(platformTransactionManager);
    }

    @Bean
    @Conditional(value = MyCondition.class)
    public PlatformTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }


}
