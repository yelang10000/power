package com.sun.power.modules.system.user.service;

import com.sun.power.core.common.entity.BaseDeleteRequestBodyVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.service.Impl.BaseService;
import com.sun.power.modules.system.user.dto.QueryUserVo;
import com.sun.power.modules.system.user.dto.AddUserVo;
import com.sun.power.modules.system.user.dto.UpdatePasswordVo;
import com.sun.power.modules.system.user.dto.UpdateUserVo;
import com.sun.power.modules.system.user.entity.User;

/**
 * @Author 贾涛
 * @Date 2020/10/19 16:07
 * @Version 1.0
 */
public interface UserService  extends BaseService<AddUserVo, BaseDeleteRequestBodyVO, UpdateUserVo, QueryUserVo, User> {

    /***
     * phonenumber的唯一性校验
     * @param phonenumber
     * @return  true成功     false失败
     */
    boolean phonenumberOnlyCheckout(String phonenumber);

    /***
     * id_card的唯一性校验
     * @param idCard
     * @return  true成功     false失败
     */
    boolean idCardOnlyCheckout(String idCard);
    /***
     * 重置工作人员密码
     * @param  userId
     */
    void resetPassword(String  userId);

    /***
     * 修改密码
     * @param  updatePasswordVo
     */
    void updatePassword(UpdatePasswordVo updatePasswordVo, BaseRequestVo baseRequestVo);

    /***
     * 重置统计分析查看密码
     * @param  userId
     */
    void resetPasswordForAnalysis(String  userId);

    /***
     * 修改统计分析查看密码
     * @param  updatePasswordVo
     */
    void updatePasswordForAnalysis(UpdatePasswordVo updatePasswordVo,BaseRequestVo baseRequestVo);



}
