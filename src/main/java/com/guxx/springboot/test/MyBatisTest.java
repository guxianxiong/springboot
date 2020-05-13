package com.guxx.springboot.test;

import com.guxx.springboot.entity.pojo.User;
import com.guxx.springboot.repository.UserDao;
import com.guxx.springboot.repository.impl.UserDaoImpl;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTest {


  public static void main(String[] args) {
    // 指定全局配置文件
    String resource = "mybatis-config.xml";

    try {
      // 读取配置文件
      InputStream inputStream = Resources.getResourceAsStream(resource);
      // 构建sqlSessionFactory
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

      // 获取sqlSession
      SqlSession sqlSession = sqlSessionFactory.openSession();
      // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
      // 第二个参数：指定传入sql的参数：这里是用户id
//      User user = sqlSession.selectOne("MyMapper.selectUser", 1);

//      System.out.println(ReflectionToStringBuilder.toString(user));

      UserDao userDao = new UserDaoImpl(sqlSession);

      User user = userDao.queryUserById("1");
      System.out.println(ReflectionToStringBuilder.toString(user));

      List<User> userList = userDao.queryUserAll();
      for (User u : userList) {
        System.out.println(ReflectionToStringBuilder.toString(u));
      }


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
