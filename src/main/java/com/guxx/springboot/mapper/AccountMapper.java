package com.guxx.springboot.mapper;

import com.guxx.springboot.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper extends MyBatisBaseDao<Account, Integer, AccountExample> {

}
