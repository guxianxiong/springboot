package com.guxx.springboot.controller;

import com.guxx.springboot.RespStat;
import com.guxx.springboot.entity.Account;
import com.guxx.springboot.service.AccountService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  @Autowired
  AccountService accountService;

  @GetMapping("/register")
  public String register (Model map) {

    map.addAttribute("obj", "aa");
    map.addAttribute("success", "保存成功");
    return "register";
  }

  @PostMapping("/register")
  public String registerP (HttpServletRequest request, Account account) {

    RespStat stat = accountService.save(account);
    request.setAttribute("stat", stat);

    return "register";
  }


}
