package com.sun.power.modules.system.dictionary.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : 贾涛
 * @date : 2019/4/22  14:28
 */
@ApiModel(value="字段创建入参",description="创建字段")
@Data
public class DictionaryAdd {

    @ApiModelProperty(value = "字典值id", name = "id")
    private String id;

    @ApiModelProperty(value = "编号", name = "code",  hidden = true)
    private String code;

    @ApiModelProperty(value = "字段类别（英文）", name = "name")
    private String name="dict_default";

    @ApiModelProperty(value = "字段类别（中文）", name = "chineseName")
    private String chineseName;

    @ApiModelProperty(value = "名称", name = "remarks")
    private String remarks;

    @ApiModelProperty(value = "排序标识", name = "orderCode",hidden = true)
    private Integer orderCode = 1;
}
