package com.sun.power.modules.system.role.dto;

import com.sun.power.core.aop.mysql.MysqlQueryFieldHandle;
import com.sun.power.core.common.entity.BaseRequestVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: caoxin
 * @Date: 2019/4/18
 * @Description: 查询所有、模糊查询请求
 */
@Data
public class QueryRoleVo extends BaseRequestVo {
    @MysqlQueryFieldHandle
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "当前页",  required = false, example = "1")
    private Integer currentPage;

    @ApiModelProperty(value = "页面大小",  required = false, example = "20")
    private Integer pageSize;

}
