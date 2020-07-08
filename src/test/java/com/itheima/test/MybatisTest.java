/*
 * Copyright (c) 2020 itheima.com All Rights Reserved.FileName: MybatisTest.java@author: lvyang@date: 20-6-15 上午10:05
 */

package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class MybatisTest {
  SqlSessionFactory sqlSessionFactory;
  SqlSession sqlSession;
  UserMapper mapperProxy;

  @Before
  public void before() throws IOException {
    InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    sqlSessionFactory = builder.build(is);//需要看，mybatis初始化过程
    is.close();
    sqlSession = sqlSessionFactory.openSession();//需要看
    mapperProxy = sqlSession.getMapper(UserMapper.class);//需要看
  }

  @Test
  public void test1(){
    User user = new User();
    Account account = new Account();
    //user.setAccount(account);
    account.setMoney(500);
    List<User> users =  mapperProxy.findUserByCondition(user);
    for (User user1 : users) {
      System.out.println(user1);
    }
  }

  @Test
  public void test2(){
    User user = new User();
    Account account = new Account();
    int time = 1000000;
    long start = System.currentTimeMillis();
    for (int i = 0; i < time; i++) {
      Class<? extends User> aClass = user.getClass();
      try {
        Method setAccount = aClass.getDeclaredMethod("setAccount", Account.class);
        setAccount.invoke(user, account);
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      }
    }
    long end = System.currentTimeMillis();

    System.out.println("通过反射设置属性：" + (end - start));
    long start2 = System.currentTimeMillis();
    for (int i = 0; i < time; i++) {
      //user.setAccount(account);
    }
    long end2 = System.currentTimeMillis();
    System.out.println("直接设置属性：" + (end2 - start2));
  }

  @Test
  public void testFindAll(){
    List<User> users = mapperProxy.findAll();
    for (User user : users) {
      System.out.println(user);
    }
  }

  @Test
  public void test4(){
    Collection<Integer> col = new HashSet();
    for (int i = 0; i < 10000000; i++) {
      col.add(i);
    }

    long start = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
      if(col.contains(100)){
      }
    }
    long end = System.currentTimeMillis();
    System.out.println("hashset判断100万次："+(end-start));

    col = new ArrayList<>();
    for (int i = 0; i < 10000000; i++) {
      col.add(i);
    }

    start = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
      if(col.contains(100)){
      }
    }
    end = System.currentTimeMillis();
    System.out.println("ArrayList判断100万次："+(end-start));

  }


  @Test
  public void after(){
    sqlSession.commit();
    sqlSession.close();
  }
}
