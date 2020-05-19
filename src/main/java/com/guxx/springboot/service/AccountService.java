package com.guxx.springboot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    long n = accountMapper.countByExample(accountExample);
    List<Account> list = accountMapper.selectByExample(accountExample);

    return list.size() == 0 ? null : list.get(0);
  }

  public PageInfo<Account> findByPage(int pageNum, int pageSize) {

    PageHelper.startPage(pageNum, pageSize);

    AccountExample example = new AccountExample();
    List<Account> list = accountMapper.selectByExample(example);
    return new PageInfo<>(list, 5);

  }

  public RespStat deleteById(int id) {

    // 1. 要提示用户
    // 2. 通过删除标记 数据永远删不掉    / update 只做增，而不是直接改表内容  // 历史数据 表（数据库）  -> 写文本log
    int row = accountMapper.deleteByPrimaryKey(id);

    if(row == 1) {

      return RespStat.build(200);
    }else {
      return RespStat.build(500, "删除出错");
    }
  }
}
