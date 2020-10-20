package com.sun.power.core.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**  
* 类说明   
*  
* @author 贾涛
* @date 2018年9月26日  新建  
*/
@Data
public class BaseDeleteRequestBodyVO{
    
    @NotNull
    @ApiModelProperty(value = "需要删除资源id数组",  required = true)
    private List<String> ids;

}
