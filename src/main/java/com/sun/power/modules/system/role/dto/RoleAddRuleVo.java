package com.sun.power.modules.system.role.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author : caoxin
 * @Date: 2019/4/18
 * @Description: 角色添加权限类
 */
@Data
public class RoleAddRuleVo {

    @NotNull
    @ApiModelProperty(value = "需要添加权限id集合",  required = true)
    private List<String> ids;

    @ApiModelProperty(value="角色id",required = true)
    private String roleId;

    @ApiModelProperty(value="createUserId",hidden = true)
    private String createUserId;

    @ApiModelProperty(value="gmtCreate",hidden = true)
    private Date gmtCreate;

    @ApiModelProperty(value="createOrgId",hidden = true)
    private String createOrgId;
}
