package org.geekbang.thinking.in.spring.aop.features.transactional.dao;

public interface AccountDao {
    default void lessenBalance(int id, double balance) {
        lessenBalance(id, balance, "account");
    }

    //减少余额
    void lessenBalance(int id, double balance, String tableName);

    default void addBalance(int id, double balance) {
        addBalance(id, balance, "account");
    }

    //增加余额
    void addBalance(int id, double balance, String tableName);
}
