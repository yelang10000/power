package com.sun.power.core.common.service.Impl;

import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;

/**
* 基础业务服务接口  
*  
* @author 贾涛
* @date 2018年9月5日  新建  
*/
public interface BaseLogicService<T,S,M,D>{
    
    //T返回数据类
    //S查询入参类
    //M插入入参类
    // 更新入参类
    //D删除入参类
    
    //查询列表
    public PageBean<T> findItems(S requestVo);
    
    //根据id查询数据实体
    public T findItemById(String userId);
    
    //根据id修改
    public void putItemById(String userId, M requestVo, BaseRequestVo baseRequestVo);
    
    //新增记录
    public void insertItem(M requestVo, BaseRequestVo baseRequestVo);
    
    //批量删除
    public void deleteByIds(D requestVo, BaseRequestVo baseRequestVo);
}
