package org.geekbang.thinking.in.spring.aop.features.transactional.dao;

public interface AccountDao {
	//减少余额
	void lessenBalance(int id,double balance);
	//增加余额
	void addBalance(int id,double balance);
}
