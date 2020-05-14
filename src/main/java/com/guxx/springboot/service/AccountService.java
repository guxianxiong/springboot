package com.guxx.springboot.service;

import com.guxx.springboot.RespStat;
import com.guxx.springboot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {



  public RespStat save(Account account) {


    return RespStat.build(200);


  }

}
