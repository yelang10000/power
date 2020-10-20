package com.sun.power.modules.system.user.dto;


import com.sun.power.core.aop.mysql.MysqlQueryFieldHandle;
import com.sun.power.core.common.entity.BaseRequestVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : caoxin
 * @Date: 2019/4/18
 * @Description: 查询所有、模糊查询请求
 */
@Data
public class QueryUserVo extends BaseRequestVo {
    @MysqlQueryFieldHandle
    @ApiModelProperty(value = "登陆姓名",  required = false)
    private String userName;

    @ApiModelProperty(value = "单位id",  required = false)
    private String organizationId;

    @ApiModelProperty(value = "专/兼职",  required = false)
    private String fullPart;

    @MysqlQueryFieldHandle
    @ApiModelProperty(value="所属部门")
    private String department;

    @MysqlQueryFieldHandle
    @ApiModelProperty(value = "工作人员姓名",  required = false)
    private String realName;

    @ApiModelProperty(value = "当前页",  required = false, example = "1")
    private Integer currentPage;

    @ApiModelProperty(value = "页面大小",  required = false, example = "20")
    private Integer pageSize;

}
