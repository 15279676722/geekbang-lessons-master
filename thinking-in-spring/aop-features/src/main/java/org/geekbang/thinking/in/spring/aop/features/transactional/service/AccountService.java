package org.geekbang.thinking.in.spring.aop.features.transactional.service;


import java.io.IOException;

public interface AccountService {
	//实现转账的业务方法
	double accountBalance(int lessenId,int addId,double balance) throws  Exception;
}
