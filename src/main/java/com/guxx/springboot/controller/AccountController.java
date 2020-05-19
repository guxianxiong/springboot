package com.guxx.springboot.controller;


import com.github.pagehelper.PageInfo;
import com.guxx.springboot.RespStat;
import com.guxx.springboot.entity.Account;
import com.guxx.springboot.service.AccountService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @RequestMapping("/list")
  public String list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5" ) int pageSize, Model model) {
    PageInfo<Account> page = accountService.findByPage(pageNum, pageSize);
    model.addAttribute("page", page);
    return "/account/list";
  }

  @RequestMapping("/deleteById")
  @ResponseBody
  public RespStat deleteById(int id) {
    // 标记一下 是否删除成功？  status
    RespStat stat = accountService.deleteById(id);

    return stat;
  }

}
