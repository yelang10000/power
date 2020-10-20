package com.sun.power.modules.system.organization.dto;


import com.sun.power.core.aop.mysql.MysqlQueryFieldHandle;
import com.sun.power.core.common.entity.BaseRequestVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @Description:    组织查询条件基类
* @Author:         贾涛
* @CreateDate:     2019/4/19 10:40
* @UpdateUser:     贾涛
* @UpdateDate:     2019/4/19 10:40
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Data
public class OrgSelectVO extends BaseRequestVo {

    @MysqlQueryFieldHandle
    @ApiModelProperty(value = "组织名称",  required = false)
    private String organizationName;

    @ApiModelProperty(value = "父组织id",  required = false)
    private String parentEmployerId;

    @ApiModelProperty(value = "组织id",  hidden = true)
    private String orgId;


}
