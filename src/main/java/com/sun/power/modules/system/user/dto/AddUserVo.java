package com.sun.power.modules.system.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author : caoxin
 * @Date: 2019/4/18
 * @Description: 新增请求类/编辑类
 * createUserId 创建用户id
 * updateUserId 更新用户id
 * createOrgId 创建组织Id
 */
@Data
public class AddUserVo {
    @ApiModelProperty(value="id" ,hidden = true)
    private String id;

    @ApiModelProperty(value="真实姓名" ,required = true)
    private String realName;

    @ApiModelProperty(value="性别",required = true)
    private String  dictSex;

    @ApiModelProperty(value="手机号码" ,required = true)
    private String phoneNumber;

    @ApiModelProperty(value="所属单位id" ,required = true)
    private String organizationId;

    @ApiModelProperty(value="角色id" ,required = true)
    private String roleId;

    @ApiModelProperty(value="用户名",required = true)
    private String userName;

    @ApiModelProperty(value="身份证",required = true)
    private String idCard;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value="生日日期",required = true)
    private Date dateOfBirth;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value="生日日期",required = true)
    private Date timeOfLogin;

    @ApiModelProperty(value="用户密码",hidden = true)
    private String password;



    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value="入党时间",hidden = true)
    private String partyTime;

    @ApiModelProperty(value="createUserId",hidden = true)
    private String createUserId;
    @ApiModelProperty(value="createOrgId",hidden = true)
    private String createOrgId;



    @ApiModelProperty(value = "民族")
    private String dictNation;

    @ApiModelProperty(value = "政治面貌")
    private String dictPoliticalStatus;

    @ApiModelProperty(value = "学历")
    private String dictDegree;

}
