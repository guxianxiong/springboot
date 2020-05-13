package com.guxx.springboot.mapper;

import com.guxx.springboot.model.Account;
import com.guxx.springboot.model.AccountExample;
import org.springframework.stereotype.Repository;

/**
 * AccountDAO继承基类
 */
@Repository
public interface AccountDAO extends MyBatisBaseDao<Account, Integer, AccountExample> {
}