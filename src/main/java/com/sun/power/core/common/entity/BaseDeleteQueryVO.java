package com.sun.power.core.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**  
* 基础删除查询入参类  
*  
* @author 贾涛
* @date 2018年9月26日  新建  
*/
@Data
public class BaseDeleteQueryVO  {
    
    private List<String> ids;

    @ApiModelProperty(value = "更新时间",hidden = true)
    private Date gmtModified;
    @ApiModelProperty(value = "更新人id",hidden = true)
    private String updateUserId;


}
