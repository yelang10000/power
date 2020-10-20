package com.sun.power.core.shiro.login.dto;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

import com.sun.power.core.shiro.ShiroUser;
import com.sun.power.modules.system.rule.dto.ResultRuleVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : 贾涛
 * @date : 2019/3/29  13:56
 */
@Data
public class UserRedisVo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户名
     */
    private String username;
    /**
     * taken
     */
    private String token;

    //登录用户信息
    @ApiModelProperty(value="用户信息",hidden=true)
    private ShiroUser userInfo;


    //权限名称列表
    @ApiModelProperty(value="权限列表",hidden=true)
    private List<String> authorityList;

    //权限名称列表
    @ApiModelProperty(value="资源列表",hidden=true)
    private List<ResultRuleVo> ruleList;

    //老干部局可查询组织id列表
    private String dataAuthSql;



}
