/*
 * Copyright (c) 2020 itheima.com All Rights Reserved.FileName: IgnoreMethod.java@author: lvyang@date: 20-6-15 下午2:30
 */

package org.apache.ibatis.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IgnoreMethod {
}
