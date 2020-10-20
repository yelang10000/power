package com.sun.power.modules.system.dictionary.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : 贾涛
 * @date : 2019/4/22  14:28
 */
@ApiModel(value="字段删除入参",description="用于删除字段")
@Data
public class DictionaryDelete {
    @ApiModelProperty(value = "需要删除的字段id数组",  required = true)
    private int[] ids;

    private String[] idsDictionary;
}
