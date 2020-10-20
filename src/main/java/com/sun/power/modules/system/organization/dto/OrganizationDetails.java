package com.sun.power.modules.system.organization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
* @Description:    组织单位详情信息基类
* @Author:         贾涛
* @CreateDate:     2019/4/18 18:32
* @UpdateUser:     贾涛
* @UpdateDate:     2019/4/18 18:32
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Data
public class OrganizationDetails {

    @ApiModelProperty(value="组织id")
    private String id;
    @ApiModelProperty(value="组织排序")
    private Long sort;
    @ApiModelProperty(value="组织名称")
    private String organizationName;
    @ApiModelProperty(value="父组织id")
    private String parentEmployerId;
    @ApiModelProperty(value="父组织名称")
    private String parentOrganizationName;
    @ApiModelProperty(value="是否老干部局")
    private Integer isLgbMinistry;
    @ApiModelProperty(value="组织性质")
    private String dictOrganizationType;
    @ApiModelProperty(value="组织电话")
    private String organizationTelphone;
    @ApiModelProperty(value="组织级别")
    private Integer dictRank;
    @ApiModelProperty(value="子组织")
    private List<OrganizationDetails> children;
    @ApiModelProperty(value="是否有子单位")
    private Integer isSubunit;
    @ApiModelProperty(value="创建时间")
    private Date gmtCreate;
    @ApiModelProperty(value="社区居委会地址")
    private String communityAddress;
}