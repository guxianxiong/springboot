package com.guxx.springboot.entity.pojo;

import java.util.Date;

public class User {
  private String id;
  private String userName;
  private String password;
  private String name;
  private Integer age;
  private Integer sex;
  private Date birthday;
  private String created;
  private String updated;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }


}




/*
DROP TABLE IF EXISTS user;
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
 */

/*
INSERT INTO test.`user` ( user_name, password, name, age, sex, birthday, created, updated)
VALUES
	( 'zpc', '123456', '鹏程', 22, 1, '1990-09-02', SYSDATE( ), SYSDATE( ) )

INSERT INTO test.USER ( user_name, `password`, `name`, age, sex, birthday, created, updated )
VALUES
	( 'hj', '123456', '静静', 22, 1, 1993-09-05, sysdate( ), sysdate( ) )


 */