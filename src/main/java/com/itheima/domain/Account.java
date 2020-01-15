/*
 * Copyright (c) 2020 itheima.com All Rights Reserved.FileName: Account.java@author: lvyang@date: 20-1-15 上午9:11
 */

package com.itheima.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
public class Account {
  private Integer money;	//decimal
  private Integer uid;	//int
}
