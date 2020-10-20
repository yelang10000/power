package com.sun.power.modules.system.dictionary.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : 贾涛
 * @date : 2019/4/22  14:28
 */
@ApiModel(value="字段修改入参",description="更新字段")
@Data
public class DictionaryUpdate {
    private Integer id;

    @ApiModelProperty(value = "名称", name = "name",  required = false)
    private String name;

    @ApiModelProperty(value = "中文名称", name = "chineseName",  required = false)
    private String chineseName;

    @ApiModelProperty(value = "code", name = "chineseName",  required = false)
    private String code;


    @ApiModelProperty(value = "名称", name = "remarks",  required = false)
    private String remarks;

    @ApiModelProperty(value = "排序标识", name = "orderCode",  required = false)
    private Integer orderCode;
}
