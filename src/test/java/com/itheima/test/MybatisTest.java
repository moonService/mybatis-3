package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.query.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class MybatisTest {
  SqlSessionFactory sqlSessionFactory;
  SqlSession sqlSession;
  UserMapper mapperProxy;

  @Before
  public void before() throws IOException {
    //初始化流程
    InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    Properties properties = new Properties();
    properties.put("jdbc.username","root");
    sqlSessionFactory = builder.build(is,properties);
    is.close();
    sqlSession = sqlSessionFactory.openSession();
    mapperProxy = sqlSession.getMapper(UserMapper.class);
  }

  @Test
  public void testFindAllWithFields(){
    List<User> users = mapperProxy.findAllWithFields();
    //List<User> users = sqlSession.selectList("com.itheima.mapper.UserMapper.findAllWithFields");
    for (User user : users) {
      System.out.println(user);
    }
  }

  @Test
  public void testFindAllUserRoleAccount(){
    List<User> users = mapperProxy.findAllUserRoleAccount();
    for (User user : users) {
      System.out.println(user);
    }
  }

  @Test
  public void testFindAllWithContruct(){
    List<User> users = mapperProxy.findAllWithContruct();
    for (User user : users) {
      System.out.println(user);
    }
  }


  @Test
  public void testFindAll(){
    QueryVo queryVo = new QueryVo();
    queryVo.setUsername("六");
    List<User> users = mapperProxy.findAll(queryVo);
    for (User user : users) {
      System.out.println(user);
    }
  }

  @Test
public void testFindAllUserEx(){
    List<User> users = mapperProxy.findAllUserEx();
    for (User user : users) {
      System.out.println(user);
    }
  }

  @Test
  public void after(){
    sqlSession.commit();
    sqlSession.close();
  }
}
