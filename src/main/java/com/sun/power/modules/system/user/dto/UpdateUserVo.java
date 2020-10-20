package com.sun.power.modules.system.user.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : 贾涛
 * @Date: 2019/4/18
 * @Description: 新增请求类/编辑类
 * createUserId 创建用户id
 * updateUserId 更新用户id
 * createOrgId 创建组织Id
 */
@Data
public class UpdateUserVo {

    @ApiModelProperty(value="id" ,required = true)
    private String id;

    @ApiModelProperty(value="真实姓名" ,required = true)
    private String realName;

    @ApiModelProperty(value="性别",required = true)
    private String dictSex;

    @ApiModelProperty(value="手机号码" ,required = true)
    private String phoneNumber;

    @ApiModelProperty(value="所属单位id" ,required = true)
    private String organizationId;

    @ApiModelProperty(value="角色id" ,required = true)
    private String roleId;

    @ApiModelProperty(value="身份证")
    private String idCard;


    @ApiModelProperty(value="updateUserId",hidden = true)
    private String updateUserId;

    @ApiModelProperty(value="所属部门")
    private String department;

    @ApiModelProperty(value="专兼职")
    private int fullPart;

    @ApiModelProperty(value="生日日期")
    private String dateOfBirth;

    @ApiModelProperty(value="是否为社区工作人员")
    private int isCommunity;

    @ApiModelProperty(value="社区Id")
    private String communityId;

    @ApiModelProperty(value="社区Id")
    private String community;

    @ApiModelProperty(value="工作人员状态 1在职 2离职 3退休")
    private Integer state = 1;


}
