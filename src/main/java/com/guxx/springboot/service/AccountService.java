package com.guxx.springboot.service;

import com.guxx.springboot.RespStat;
import com.guxx.springboot.entity.Account;
import com.guxx.springboot.mapper.AccountExample;
import com.guxx.springboot.mapper.AccountMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  @Autowired
  AccountMapper accountMapper;

  public RespStat save(Account account) {


    return RespStat.build(200);


  }

  public Account findByLoginNameAndPassword(String loginName, String password) {
    AccountExample accountExample = new AccountExample();
    accountExample.createCriteria().andLoginNameEqualTo(loginName).andPasswordEqualTo(password);


    List<Account> list = accountMapper.selectByExample(accountExample);

    return list.size() == 0 ? null : list.get(0);
  }
}
