package org.geekbang.thinking.in.spring.aop.features.transactional.service.impl;



import org.geekbang.thinking.in.spring.aop.features.transactional.dao.AccountDao;
import org.geekbang.thinking.in.spring.aop.features.transactional.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 *
 */
@Service
@Transactional(value = "dataSourceTransactionManager", rollbackFor = Exception.class)
public class AccountServiceAnnoImpl implements AccountService {
	@Autowired
	AccountDao accountDao;

	@Override
	public double accountBalance(int lessenId, int addId, double balance) throws Exception {
		//某个账号减少金额
		accountDao.lessenBalance(lessenId, balance);

		//走个账号增加金额
		accountDao.addBalance(addId, balance);

		//模拟出现异常
//		int a=5/0;
		//IOException不会进行事务的回滚 只会回滚RunTimeException和Error 需要回滚可以加上参数rollbackFor
//		throw new IOException();
		return balance;
	}

}
