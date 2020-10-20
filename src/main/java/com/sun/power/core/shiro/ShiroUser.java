package com.sun.power.core.shiro;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : 贾涛
 * @date : 2019/3/29  10:25
 */
@Data
public class ShiroUser implements Serializable {

    /**
     * 主键ID
     */
    public String id;
    /**
     * 账号
     */
    public String account;
    /**
     * 姓名
     */
    public String name;

    /**
     * 角色集
     */
    public List<String> roleList;

    /**
     *  角色名称集
     */
    public List<String> roleNames;

    /**
     *  所属单位id
     */
    @ApiModelProperty(value="所属单位id")
    private String organizationId;

    /**
     *  所属单位id
     */
    @ApiModelProperty(value="所属单位名称")
    private String organizationName;

    /**
     *  所属系统
     */
    @ApiModelProperty(value="所属系统")
    private String dictSubordinate;

    /**
     *  所属系统名称
     */
    @ApiModelProperty(value="所属系统名称")
    private String dictSubordinateName;

    /**
     *  现管单位
     */
    @ApiModelProperty(value="现管单位")
    private String nowThePipeUnits;

    /**
     *  现管单位name
     */
    @ApiModelProperty(value="现管单位name")
    private String nowThePipeUnitsName;


    /**
     *  创建组织id
     */
    @ApiModelProperty(value="创建组织id")
    private String createOrgId;

    /**
     * 所属支部id
     */
    @ApiModelProperty(value="支部id")
    private String partyId;

    @ApiModelProperty(value="是否为社区工作人员")
    private int isCommunity;

    @ApiModelProperty(value="社区id")
    private String communityId;

    @ApiModelProperty(value="IM用户id")
    private String imUserId;

    @ApiModelProperty(value="工作人员所属系统")
    private String systemBelong;

    @ApiModelProperty(value="单位级别")
    private int dictRank;

    @ApiModelProperty(value="社区")
    private String community;

    @ApiModelProperty(value="是否管理员 0-否 1-是")
    private Integer isAdmin;

}
