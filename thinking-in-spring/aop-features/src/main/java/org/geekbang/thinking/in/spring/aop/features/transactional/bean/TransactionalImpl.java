package org.geekbang.thinking.in.spring.aop.features.transactional.bean;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Transactional
@Component
public class TransactionalImpl {
    public void publicMethod() throws Exception {
        Random random = new Random();
        if(random.nextBoolean()){
            throw new Exception("Exception Rollback");
        }
    }
    private void privateMethod() throws Exception {
        Random random = new Random();
        if(random.nextBoolean()){
            throw new Exception("Exception Rollback");
        }
    }
}
