package com.sun.power.modules.system.rule.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author : caoxin
 * @Date: 2019/4/18
 * @Description: 新增请求类
 * createUserId 创建用户id
 * updateUserId 更新用户id
 * createOrgId 创建组织Id
 */
@Data
public class AddRuleVo {

    @ApiModelProperty(value="id",hidden = true)
    private String id;

    @ApiModelProperty(value="一级权限id")
    private String parentRuleId;

    @ApiModelProperty(value="权限名称",required = true)
    private String ruleName;

    @ApiModelProperty(value="描述")
    private String remark;
    @ApiModelProperty(value="url",hidden = true)
    private String url;
    @ApiModelProperty(value="createUserId",hidden = true)
    private String createUserId;
    @ApiModelProperty(value="gmtCreate",hidden = true)
    private Date gmtCreate;
    @ApiModelProperty(value="createOrgId",hidden = true)
    private String createOrgId;

}
