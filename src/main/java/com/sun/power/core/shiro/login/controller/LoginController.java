package com.sun.power.core.shiro.login.controller;

import com.sun.power.core.shiro.login.dto.UserLogin;
import com.sun.power.core.shiro.login.dto.UserRedisVo;
import com.sun.power.core.shiro.login.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Author 贾涛
 * @Date 2020/10/15 17:06
 * @Version 1.0
 */
@Api(value="/login",tags="系统登录")
@Slf4j
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Resource
    private RedisTemplate<String, UserRedisVo> redisTemplate;
    /**
     * 点击登录执行的动作
     */
    @ApiOperation(value = "登录", notes = "作者：贾涛，最后更新时间：2018/12/13", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public UserRedisVo loginVali(HttpServletRequest request, @RequestBody @Valid UserLogin userLogin, String appMark) {
        UserRedisVo userRedisVo= loginService.logIn(request,userLogin.getUsername(),userLogin.getPassword(),userLogin.getVerifyCode());


        return  userRedisVo;
    }
    /**
     * 退出登录
     */
    @ApiOperation(value = "登出", notes = "作者：贾涛，最后更新时间：2018/12/13", httpMethod = "POST")
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    @ResponseBody
    public String logOut(String token) {
        try {
            loginService.logOut(token);
        }catch (Exception e ){
            return  "UnusualExit";
        }
        return"正常退出";
    }
}
