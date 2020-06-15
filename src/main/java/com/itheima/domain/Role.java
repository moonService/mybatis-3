/*
 * Copyright (c) 2020 itheima.com All Rights Reserved.FileName: Role.java@author: lvyang@date: 20-1-15 上午9:11
 */

package com.itheima.domain;

import lombok.Data;

@Data
public class Role {
  private Integer id;	//int
  private String roleName;	//varchar

  public Role(Integer id, String roleName) {
    this.id = id;
    this.roleName = roleName;
  }
  public Role() {
  }
}
