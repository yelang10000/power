package com.sun.power.modules.system.dictionary.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Relation {
    @ApiModelProperty(value = "id", name = "dataType",  required = true)
    private Integer id;

    @ApiModelProperty(value = "名称", name = "name",  required = true)
    private String name;

    @ApiModelProperty(value = "字段类别（中文）", name = "chineseName",  required = true)
    private String chineseName;

    @ApiModelProperty(value = "是否常用", required = true)
    private String isCommonlyUsed;

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
