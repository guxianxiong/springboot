package com.guxx.springboot.repository;

import com.guxx.springboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {


}
