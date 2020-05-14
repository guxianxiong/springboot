package com.guxx.springboot.filter;


import java.io.IOException;
import java.util.logging.LogRecord;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 * 用户权限处理
 */
@Component
@WebFilter(urlPatterns = "/*")
public class AccountFilter implements Filter {

  private final String[] IGNORE_URI = {"/index", "/account/login", "/css", "/js", "/images"};

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest)request;
    HttpServletResponse resp = (HttpServletResponse)response;

    String uri = req.getRequestURI();
    uri = uri.replace("/demo", "");

    boolean pass = canPassIgnore(uri);
    if (pass) {
      chain.doFilter(request, response);
      return;
    }

    Object account = req.getSession().getAttribute("account");
    if (null == account) {
      resp.sendRedirect("/demo/account/login");
      return;
    }

    chain.doFilter(request, response);
  }

  private boolean canPassIgnore(String uri) {
    for (String val: IGNORE_URI) {
      if (uri.startsWith(val)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }
}
