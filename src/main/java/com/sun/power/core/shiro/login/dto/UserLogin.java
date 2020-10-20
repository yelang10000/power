package com.sun.power.core.shiro.login.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : 贾涛
 * @date : 2019/5/8  10:52
 */
@Data
public class UserLogin {
    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名",notes = "作者：贾涛，最后更新时间：2019/05/08")
    @NotNull(message = "用户名不能为空！")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码",notes = "作者：贾涛，最后更新时间：2019/05/08")
    @NotNull(message = "密码不能为空！")
    private String password;

//    /**
//     * APP标识
//     */
//    @ApiModelProperty(value="APP标识：默认PC,APP端=APP",notes = "作者：贾涛，最后更新时间：2019/05/08")
//    String appMark="PC";

    @ApiModelProperty(value="验证码",notes = "作者：贾涛，最后更新时间：2020/03/24")
    private String verifyCode;
}
