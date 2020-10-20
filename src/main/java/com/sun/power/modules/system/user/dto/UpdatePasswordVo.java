package com.sun.power.modules.system.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : caoxin
 * @Date: 2019/4/18

 */
@Data
public class UpdatePasswordVo {

    @ApiModelProperty(value = "id",required = true)
    private String id;

    @ApiModelProperty(value = "原密码",required = true)
    private String rawPassword;

    @ApiModelProperty(value = "新密码",required = true)
    private String newPassword;

    @ApiModelProperty(value = "updateUserId",hidden = true)
    private String updateUserId;


}
