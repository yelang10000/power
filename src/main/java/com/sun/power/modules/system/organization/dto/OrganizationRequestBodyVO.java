package com.sun.power.modules.system.organization.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @Description:    组织信息基类
* @Author:         贾涛
* @CreateDate:     2019/4/17 17:11
* @UpdateUser:     贾涛
* @UpdateDate:     2019/4/17 17:11
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Data
public class OrganizationRequestBodyVO {
    
    @ApiModelProperty(value="组织名称",required = true)
    private String organizationName;

    @ApiModelProperty(value="组织电话",hidden = true)
    private String organizationTelphone;

    @ApiModelProperty(value="父组织id",required = true)
    private String parentEmployerId;

    @ApiModelProperty(value="组织排序",hidden = false)
    private Long sort=1L;


}
