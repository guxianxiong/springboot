package com.guxx.springboot.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {
  public static void main(String[] args) throws Exception {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    try {

      // 加载驱动
      Class.forName("com.mysql.jdbc.Driver");

      // 获取连接
      String url = "jdbc:mysql://rm-uf6679g6s5b9i492dro.mysql.rds.aliyuncs.com:3306/test";
      String user = "guxianxiong";
      String password = "Pass1234";
      connection = DriverManager.getConnection(url, user, password);

      // 获取 statement, preparedStatement
      String sql = "select * from user where id = ?";
      preparedStatement = connection.prepareStatement(sql);

      // 设置参数
      preparedStatement.setLong(1, 1l);


      // 执行查询
      rs = preparedStatement.executeQuery();

      // 处理结果
      while (rs.next()) {
        System.out.println(rs.getString("user_name"));
        System.out.println(rs.getString("name"));
        System.out.println(rs.getInt("age"));
        System.out.println(rs.getDate("birthday"));

      }
    } finally {
      // 关闭连接，释放资源
      if (rs != null) {
        rs.close();
      }
      if (preparedStatement != null) {
        preparedStatement.close();
      }
      if (connection != null) {
        connection.close();
      }
    }








  }

}





















