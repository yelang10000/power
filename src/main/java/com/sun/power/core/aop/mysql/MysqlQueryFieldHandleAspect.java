package com.sun.power.core.aop.mysql;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记含有需要做mysql条件查询通配符处理的参数类的方法
 *
 * @author: 朱星晨
 * @date: 2019/7/11
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MysqlQueryFieldHandleAspect {
}
