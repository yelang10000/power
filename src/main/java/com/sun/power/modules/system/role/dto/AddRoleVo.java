package com.sun.power.modules.system.role.dto;

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
public class AddRoleVo {

    @ApiModelProperty(value="id",hidden = true)
    private String id;

    @ApiModelProperty(value="角色名称",required = true)
    private String roleName;

    @ApiModelProperty(value="角色描述")
    private String remark;

    @ApiModelProperty(value="是否管理员  0 否 1 是",required = true)
    private Integer isAdmin;

    @ApiModelProperty(value="gmtCreate",hidden = true)
    private Date gmtCreate;
    @ApiModelProperty(value="createUserId",hidden = true)
    private String createUserId;
    @ApiModelProperty(value="createOrgId",hidden = true)
    private String createOrgId;
}
