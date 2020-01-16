/*
 * Copyright (c) 2020 itheima.com All Rights Reserved.FileName: ExamplePlugin.java@author: lvyang@date: 20-1-15 下午5:32
 */

package com.itheima.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({@Signature(
  type= Executor.class,
  method = "query",
  args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class ExamplePlugin implements Interceptor {
  private Properties properties = new Properties();
  public Object intercept(Invocation invocation) throws Throwable {
    System.out.println("======================================执行之前=============================");
    Object returnObject = invocation.proceed();
    System.out.println("执行结果:"+returnObject);
    System.out.println("======================================执行之后================================");
    return returnObject;
  }

  @Override
  public Object plugin(Object target) {
    return Plugin.wrap(target,this);
  }

  public void setProperties(Properties properties) {
    this.properties = properties;
  }
}
