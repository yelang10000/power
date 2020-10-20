package com.sun.power.core.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**  
* 基础vo 接收token
*  
* @author 贾涛
* @date 2018年9月13日  新建  
*/

@Data
public class BaseRequestVo{
   
    @ApiModelProperty(value="token",hidden=true)
    private String token;
    
    @ApiModelProperty(value="requestOrgId", hidden=true)
    private String requestOrgId;
    
    @ApiModelProperty(value="requestUsername", hidden=true)
    private String requestUsername;
    
    @ApiModelProperty(value="requestUserId", hidden=true)
    private String requestUserId;

    @ApiModelProperty(value="dataAuthSql", hidden=true)
    private String dataAuthSql;

    @ApiModelProperty(value="realName 根据用户姓名模糊查询",  hidden=true,required = false)
    private String realName;
    
    @ApiModelProperty(value="districtForApp APP查询", required = false)
    private String districtForApp;
    
    @ApiModelProperty(value="orgIdForDataSelect 按照组织筛选，默认为本单位以下所有组织", required = false)
    private String orgIdForDataSelect;

    @ApiModelProperty(value="All标志字段", required = false)
    private String allIndex;
    
    @ApiModelProperty(value="isNoDataAuth 选1不按照数据权限限制", required = false)
    private Long isNoDataAuth;
}
