package org.geekbang.thinking.in.spring.aop.features.transactional.dao.impl;

import org.geekbang.thinking.in.spring.aop.features.transactional.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void lessenBalance(int id, double balance) {
		jdbcTemplate.update("update account set balance=balance-? where id=?",balance,id);
	}

	@Override
	public void addBalance(int id, double balance) {
		jdbcTemplate.update("update account set balance=balance+? where id=?",balance,id);
	}
}
