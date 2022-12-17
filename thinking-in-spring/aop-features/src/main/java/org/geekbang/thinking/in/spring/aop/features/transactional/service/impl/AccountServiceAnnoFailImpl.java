package org.geekbang.thinking.in.spring.aop.features.transactional.service.impl;


import org.geekbang.thinking.in.spring.aop.features.transactional.dao.AccountDao;
import org.geekbang.thinking.in.spring.aop.features.transactional.service.AccountService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.io.IOException;

/**
 *
 */
@Service
public class AccountServiceAnnoFailImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public double accountBalance(int lessenId, int addId, double balance) throws IOException {

        //某个账号减少金额
        accountDao.lessenBalance(lessenId, balance);

        //走个账号增加金额
        accountDao.addBalance(addId, balance);

        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());

        this.transactionalFail(lessenId, addId, balance);

//        AccountServiceAnnoFailImpl accountServiceAnnoFail = (AccountServiceAnnoFailImpl) AopContext.currentProxy();
//        accountServiceAnnoFail.transactionalFail(lessenId, addId, balance);

        //模拟出现异常
//		int a=5/0;
        //IOException不会进行事务的回滚 只会回滚RunTimeException和Error 需要回滚可以加上参数rollbackFor
//        throw new Exception();

        return balance;
    }


    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public void transactionalFail(int lessenId, int addId, double balance) throws IOException {
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());

        //某个账号减少金额
        accountDao.lessenBalance(lessenId, balance, "account_new");

        //走个账号增加金额
        accountDao.addBalance(addId, balance, "account_new");
        throw new IOException();
    }

}
