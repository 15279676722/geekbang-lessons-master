package org.geekbang.thinking.in.spring.aop.features.transactional.service.impl;


import org.geekbang.thinking.in.spring.aop.features.transactional.dao.AccountDao;
import org.geekbang.thinking.in.spring.aop.features.transactional.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDao accountDao;
	@Override
	public double accountBalance(int lessenId, int addId, double balance) {
		//某个账号减少金额
		accountDao.lessenBalance(lessenId, balance);

		//走个账号增加金额
		accountDao.addBalance(addId, balance);

		//模拟出现异常
		int a=5/0;
		return balance;

	}

}
