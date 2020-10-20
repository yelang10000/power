package com.sun.power.modules.system.role.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author : caoxin
 * @Date: 2019/4/18
 * @Description: 编辑请求类
 */
@Data
public class UpdateRoleVo {

    @ApiModelProperty(value="角色")
    private String id;

    @ApiModelProperty(value="角色名称",required = true)
    private String roleName;

    @ApiModelProperty(value="角色描述")
    private String remark;

    @ApiModelProperty(value="是否管理员  0 否 1 是",required = true)
    private Integer isAdmin;

    private Date gmtModified;
    private String updateUserId;

}
