package com.sun.power.core.aop.mysql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记需要做mysql通配符处理的字段
 *
 * @author: 朱星晨
 * @date: 2019/7/11
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MysqlQueryFieldHandle {
}
