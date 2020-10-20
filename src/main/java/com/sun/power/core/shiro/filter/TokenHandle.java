package com.sun.power.core.shiro.filter;

import com.sun.power.core.common.constant.SysConstant;
import com.sun.power.core.shiro.login.dto.UserRedisVo;
import com.sun.power.core.support.ParameterRequestWrapper;
import com.sun.power.modules.system.organization.dao.OrganizationMapper;
import com.sun.power.modules.system.organization.dto.OrgDetails;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 贾涛
 * @Date 2020/10/16 22:09
 * @Version 1.0
 */
@Slf4j
public class TokenHandle {



    @Autowired
    public OrganizationMapper organizationMapper;

    public boolean checkToken(String token,  RedisTemplate<String, UserRedisVo> redisTemplate) {

        //String tokenMd5 = new SimpleHash("md5", token).toHex();
        boolean flag = redisTemplate.hasKey(token);
        System.out.println("flag:"+flag);
        return flag;
    }
    //权限验证
    public HttpServletRequest checkPower(String token, ServletRequest request,RedisTemplate<String, UserRedisVo> redisTemplate)
            throws IOException, ServletException {
        ValueOperations<String, UserRedisVo> valueops = redisTemplate.opsForValue();
        //获取权限列表
        UserRedisVo userRedisVo = valueops.get(token);
        printRedisData(token, userRedisVo);
        printAuthority(userRedisVo.getAuthorityList());
        //获取请求url url是否包含在权限列表中
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        log.info("url   :" + httpServletRequest.getRequestURI());
        if(("1000").equals(userRedisVo.getUserInfo().getCreateOrgId())){
                userRedisVo.setDataAuthSql(" AND 1=1 ");
            }else {
                StringBuilder orgIdString = new StringBuilder();
                orgIdString.append("AND create_org_id in( ");
                List<OrgDetails> orgDetails = organizationMapper.getListsAll(userRedisVo.getUserInfo().getCreateOrgId());
                if(!orgDetails.isEmpty() && orgDetails != null){
                    for (OrgDetails org:orgDetails){
                        orgIdString.append("'"+org.getId()+"'"+",");
                    }
                }else {
                    orgIdString.append("'"+userRedisVo.getUserInfo().getCreateOrgId()+"'"+",");
                }

                orgIdString.deleteCharAt(orgIdString.length() - 1);
                orgIdString.append(" )");
                userRedisVo.setDataAuthSql(orgIdString.toString());
            }
        //权限合法
        Map<String, String[]> extraParams = new HashMap<String, String[]>(request.getParameterMap());
        extraParams.put("requestOrgId", new String[]{userRedisVo.getUserInfo().getOrganizationId()});
        extraParams.put("requestUsername", new String[]{userRedisVo.getUserInfo().getAccount()});
        extraParams.put("requestUserId", new String[]{userRedisVo.getUserInfo().getId()});
        extraParams.put("dataAuthSql", new String[]{userRedisVo.getDataAuthSql()});
        httpServletRequest = new ParameterRequestWrapper(httpServletRequest, extraParams);
        return httpServletRequest;


    }
    //打印缓存信息
    private void printRedisData(String token, UserRedisVo userRedisVo) {
        log.info("redis data info:");
        log.info("token:        " + token);
        log.info("Account:    " + userRedisVo.getUserInfo().getAccount());
        log.info("org_id   :    " + userRedisVo.getUserInfo().getCreateOrgId());
        log.info("id       :    " + userRedisVo.getUserInfo().getId());
    }

    //打印权限
    private void printAuthority(List<String> authorityList) {
        log.info("authorityList:");
    }
    /**
     * 获取请求的token
     */
    public String getRequestToken(HttpServletRequest httpRequest){
        //从header中获取token
        String token = httpRequest.getHeader(SysConstant.PARAM_NAME_TOKEN);

        //如果header中不存在token，则从参数中获取token
        if(StringUtils.isBlank(token)){
            token = httpRequest.getParameter(SysConstant.PARAM_NAME_TOKEN);
        }

        return token;
    }
}
