package com.guxx.springboot.service;

import com.guxx.springboot.RespStat;
import com.guxx.springboot.entity.Account;
import com.guxx.springboot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  @Autowired
  AccountRepository accountRepository;

  public RespStat save(Account account) {

    Account entity = accountRepository.save(account);

    return RespStat.build(200);
  }
}
