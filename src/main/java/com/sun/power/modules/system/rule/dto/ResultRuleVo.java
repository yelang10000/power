package com.sun.power.modules.system.rule.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author : caoxin
 * @Date: 2019/4/18

 */
@Data
public class ResultRuleVo extends SerializableSerializer {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="id")
    private String id;

    private String parentId;

    @ApiModelProperty(value="权限名称")
    private String ruleName;

    @JsonIgnore
    @ApiModelProperty(value="描述")
    private String remark;

    @JsonIgnore
    @ApiModelProperty(value="url")
    private String url;

    @JsonIgnore
    private String path;

    @JsonIgnore
    private String name;

    @JsonIgnore
    private String component;

    private List<ResultRuleVo> routes;

    @JsonIgnore
    private int  operationAdd;
    @JsonIgnore
    private int  operationUpdate;
    @JsonIgnore
    private int  operationDelete;

    @JsonIgnore
    private com.fasterxml.jackson.databind.JsonSerializer  delegatee;

    @JsonIgnore
    private boolean  unwrappingSerializer;
}
