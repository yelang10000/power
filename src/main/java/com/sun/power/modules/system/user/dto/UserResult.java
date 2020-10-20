package com.sun.power.modules.system.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class UserResult extends SerializableSerializer {

    @ApiModelProperty(value="id")
    private String id;

    @ApiModelProperty(value="roleId")
    private String roleId;

    @ApiModelProperty(value="角色名称")
    private String roleName;

    @ApiModelProperty(value="所属单位id")
    private String organizationId;

    @ApiModelProperty(value="所属单位名称")
    private String organizationName;

    @ApiModelProperty(value="用户名")
    private String userName;

    @ApiModelProperty(value="密码")
    private String password;

    @ApiModelProperty(value="真实姓名")
    private String realName;

    @ApiModelProperty(value="身份证")
    private String idCard;

    @ApiModelProperty(value="性别")
    private String dictSex;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value="生日日期")
    private Date dateOfBirth;


    @ApiModelProperty(value="手机号码")
    private String phoneNumber;


}