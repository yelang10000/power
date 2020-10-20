package com.sun.power.modules.system.rule.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author : caoxin
 * @Date: 2019/4/18
 * @Description: 编辑请求类
 */
@Data
public class UpdateRuleVo {

    @ApiModelProperty(value="id",hidden = true)
    private String id;

    @ApiModelProperty(value="一级权限id")
    private String parentRuleId;

    @ApiModelProperty(value="权限名称",required = true)
    private String ruleName;

    @ApiModelProperty(value="描述")
    private String remark;

    @ApiModelProperty(value="url",hidden = true)
    private String url;
    @ApiModelProperty(value="updateUserId",hidden = true)
    private String updateUserId;
    @ApiModelProperty(value="gmtModified",hidden = true)
    private Date gmtModified;

}
