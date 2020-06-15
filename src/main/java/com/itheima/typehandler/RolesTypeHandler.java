/*
 * Copyright (c) 2020 itheima.com All Rights Reserved.FileName: RolesTypeHandler.java@author: lvyang@date: 20-5-19 下午2:31
 */
package com.itheima.typehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import com.itheima.domain.Role;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 * @Author: lvyang
 * @Created Date: 2020年05月19日
 * @LastModifyDate:
 * @LastModifyBy:
 * @Version:
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
public class RolesTypeHandler extends BaseTypeHandler<List<Role>> {
  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, List<Role> parameter, JdbcType jdbcType) throws SQLException {
    String rolesJson = JSON.toJSONString(parameter);
    ps.setString(i,rolesJson);
  }

  @Override
  public List<Role> getNullableResult(ResultSet rs, String columnName) throws SQLException {
    String string = rs.getString(columnName);
    List<Role> roles = JSON.parseArray(string, Role.class);
    return roles;
  }

  @Override
  public List<Role> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    String string = rs.getString(columnIndex);
    List<Role> roles = JSON.parseArray(string, Role.class);
    return roles;
  }

  @Override
  public List<Role> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    String string = cs.getString(columnIndex);
    List<Role> roles = JSON.parseArray(string, Role.class);
    return roles;
  }
}
