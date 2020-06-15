/*
 * Copyright (c) 2020 itheima.com All Rights Reserved.FileName: UserMapper.java@author: lvyang@date: 20-1-15 上午9:12
 */

package com.itheima.mapper;

import com.itheima.domain.Teacher;
import com.itheima.domain.User;
import com.itheima.query.QueryVo;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
 /* public List<User> findAll(QueryVo queryVo);

  public List<User> findAllWithContruct();

  public List<User> findAllWithFields();

  public List<Teacher> findAllTeacher();

  public List<User> findAllUserRoleAccount();

  public List<User> findAllUserEx();*/

  public List<User> findAll();

  public User findUser(Integer id);

  public int InsertUserRole(User user);
}
