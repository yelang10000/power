package com.sun.power.core.shiro.login.service;

import com.sun.power.core.common.service.Impl.BaseService;
import com.sun.power.core.shiro.login.dto.UserRedisVo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 贾涛
 * @Date 2020/10/15 17:16
 * @Version 1.0
 */
public interface LoginService extends BaseService {
    /**
     * 登录接口
     * @param username
     * @param password
     * @return
     */
    UserRedisVo logIn(HttpServletRequest request, String username, String password, String verifyCode);

    /**
     * 登出接口
     * @param token
     */
    void logOut(String token);
}
