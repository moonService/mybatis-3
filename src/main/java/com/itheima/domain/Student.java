/*
 * Copyright (c) 2020 itheima.com All Rights Reserved.FileName: Student.java@author: lvyang@date: 20-1-15 上午9:11
 */

package com.itheima.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Student extends User {
  private String userid;	//int
  private String num;	//varchar
}
