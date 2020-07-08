/*
 * Copyright (c) 2020 itheima.com All Rights Reserved.FileName: User.java@author: lvyang@date: 20-1-15 上午9:12
 */

package com.itheima.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
public class User {
  private Integer id;  //int
  private String username;  //varchar
  private Date birthday;  //datetime
  private String sex;  //char
  private String address;  //varchar
  private Account account;
  private List<Role> roles;
  public User(){
  }
  public User(Integer id, String username) {
    this.id = id;
    this.username = username;
  }

  public Integer getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public Date getBirthday() {
    return birthday;
  }

  public String getSex() {
    return sex;
  }

  public String getAddress() {
    return address;
  }

  public Account getAccount() {
    return account;
  }

  public List<Role> getRoles() {
    return roles;
  }
}



