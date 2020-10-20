package com.sun.power.core.aop.mysql;


import com.sun.power.core.aop.common.AopConstant;
import com.sun.power.core.common.entity.BaseRequestVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * mysql通配符处理切面
 *
 * @author: 朱星晨
 * @date: 2019/7/11
 */
@Aspect
@Component
@Slf4j
public class MysqlQueryFieldHandleAop {
    @Pointcut("@annotation(com.sun.power.core.aop.mysql.MysqlQueryFieldHandleAspect)")
    public void annotationPointCut() {
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint) throws IllegalAccessException {
        for (Object requestObj: joinPoint.getArgs()) {
            if(requestObj instanceof BaseRequestVo){
                log.info("MysqlQueryFieldHandleAop#before requestObj==="+requestObj);
                Field[] fields = requestObj.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(MysqlQueryFieldHandle.class)) {
                        field.setAccessible(true);
                        String value = (String) field.get(requestObj);
                        if(value!=null){
                            String newValue = value.replaceAll("%", AopConstant.ESCAPE_STR + "%").replaceAll("_", AopConstant.ESCAPE_STR + "_");
                            field.set(requestObj,newValue);
                        }
                    }
                }
            }
        }
    }

}