package com.sun.power.core.common.service.Impl;

import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;

/**
 * @author : 贾涛
 * @date : 2019/3/29  9:51
 */
public interface BaseService<T,D,M,Q,R>{


    /**
     * 参数说明
     * T 插入参数
     * D 删除参数
     * M 修改参数
     * Q 查询参数
     * R 返回结果参数
     */


    /**新增记录
     *
     * @param requestVo
     * @param baseRequestVo
     */
    public void insertItem(T requestVo, BaseRequestVo baseRequestVo);

    /**批量删除
     *
     * @param requestVo
     * @param baseRequestVo
     */
    public void deleteByIds(D requestVo, BaseRequestVo baseRequestVo);

    /**根据id修改
     *
     * @param userId
     * @param requestVo
     * @param baseRequestVo
     */
    public void putItemById(String userId, M requestVo, BaseRequestVo baseRequestVo);

    /**查询列表
     *
     * @param requestVo
     *
     * @return
     */

     public PageBean<R> findItems(Q requestVo);

    /**根据id查询数据实体
     *
     * @param userId
     * @param baseRequestVo
     * @return
     */
    public R findItemById(String userId, BaseRequestVo baseRequestVo);




}
