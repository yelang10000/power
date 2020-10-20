package com.sun.power.modules.system.organization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
public class OrgDetails {

    @ApiModelProperty(value="组织id")
    private String id;
    @ApiModelProperty(value="组织名称")
    private String organizationName;
    @ApiModelProperty(value="父组织id")
    private String parentEmployerId;
    @ApiModelProperty(value="组织性质")
    private String dictOrganizationType;
}