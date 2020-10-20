package com.sun.power.core.shiro.filter;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.sun.power.core.common.constant.SysConstant;
import com.sun.power.core.common.entity.Result;
import com.sun.power.core.exception.PowerException;
import com.sun.power.core.shiro.login.dto.UserRedisVo;
import com.sun.power.core.utils.HttpContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 贾涛
 * @Date 2020/10/16 21:52
 * @Version 1.0
 */
@Slf4j
@WebFilter(urlPatterns = {"/powers/api/v1/*"})
public class PowerSunFilter implements Filter {
    RedisTemplate<String, UserRedisVo> redisTemplate;



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
          log.info("功能权限Filter创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        TokenHandle tokenHandle=new TokenHandle();
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        ServletContext sc = request.getSession().getServletContext();
        WebApplicationContext cxt =  WebApplicationContextUtils.getWebApplicationContext(sc);
        if(cxt != null && cxt.getBean("redisTemplate") != null && redisTemplate == null){
            redisTemplate = (RedisTemplate) cxt.getBean("redisTemplate");
        }
            String token =tokenHandle.getRequestToken(request);
            if (token!=null && tokenHandle.checkToken(token,redisTemplate)){
                request= tokenHandle.checkPower(token, servletRequest,redisTemplate);
                    filterChain.doFilter(request, servletResponse);

            }else {
                //权限验证失败 token 不合法
                HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
                httpResponse.setStatus(HttpStatus.FORBIDDEN.value());
                httpResponse.setContentType("application/json;charset=UTF-8");
                httpResponse.getWriter().write(JSONObject.toJSONString(new PowerException(10050), SerializerFeature.WriteMapNullValue));
                httpResponse.getWriter().close();
            }
            return;
    }




    @Override
    public void destroy() {
        log.info("功能权限filter销毁");
    }
}
