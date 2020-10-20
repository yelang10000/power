package com.sun.power.modules.system.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class User extends SerializableSerializer {

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

    @ApiModelProperty(value="密码")
    private String passwordForAnalysis;

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

    @ApiModelProperty(value="创建用户id")
    private String createUserId;

    @ApiModelProperty(value="更新用户id")
    private String updateUserId;

    @ApiModelProperty(value="创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value="更新时间")
    private Date gmtModified;

    @ApiModelProperty(value="逻辑删除判断")
    private Byte isDeleted;

    @ApiModelProperty(value="创建组织id")
    private String createOrgId;
    @ApiModelProperty(value="入党时间")
    private String partyTime;

    private Date timeOfLogin;

    /**
     * findByUserName
     * @param id
     * @param organizationId
     * @param userName
     * @param password
     * @param realName
     * @param idCard
     * @param dictSex
     * @param dateOfBirth
     * @param phoneNumber
     * @param createUserId
     * @param updateUserId
     * @param gmtCreate
     * @param gmtModified
     * @param createOrgId
     * @param partyTime
     * @param timeOfLogin
     */
    public User(String id, String organizationId,  String userName, String password,  String realName, String idCard, String dictSex, Date dateOfBirth, String phoneNumber, String createUserId, String updateUserId, Date gmtCreate, Date gmtModified, String createOrgId, String partyTime, Date timeOfLogin) {
        this.id = id;
        this.organizationId = organizationId;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.idCard = idCard;
        this.dictSex = dictSex;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.createUserId = createUserId;
        this.updateUserId = updateUserId;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.createOrgId = createOrgId;
        this.partyTime = partyTime;
        this.timeOfLogin = timeOfLogin;
    }

    public User(String id, String roleId, String roleName, String organizationId, String organizationName, String userName, String password, String realName, String idCard, String dictSex,  String phoneNumber,Date gmtCreate,Date dateOfBirth) {
        this.id = id;
        this.roleId = roleId;
        this.roleName = roleName;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.idCard = idCard;
        this.dictSex = dictSex;
        this.phoneNumber = phoneNumber;
        this.gmtCreate=gmtCreate;
        this.dateOfBirth=dateOfBirth;
    }
}