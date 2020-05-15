package com.guxx.springboot.controller;


import com.guxx.springboot.entity.Account;
import com.guxx.springboot.service.AccountService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountController {

  @Autowired
  AccountService accountService;

  @RequestMapping("login")
  public String login() {

    return "/account/login";
  }

  /**
   * 用户登录
   * @param loginName
   * @param password
   * @param request
   * @return success 成功
   */
  @RequestMapping("validateAccount")
  @ResponseBody
  public String validataAccount(String loginName, String password, HttpServletRequest request) {
    Account account = accountService.findByLoginNameAndPassword(loginName, password);
    if (account == null) {
      return "登录失败";
    } else {
      request.getSession().setAttribute("account", account);
      return "success";
    }

  }

}
