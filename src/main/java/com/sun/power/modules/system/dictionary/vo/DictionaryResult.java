package com.sun.power.modules.system.dictionary.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : 贾涛
 * @date : 2019/4/22  14:28
 */
@ApiModel(value="字段查询出参",description="用于查询字段")
@Data
public class DictionaryResult {

    @ApiModelProperty(value = "id", name = "dataType",  required = true)
    private Integer id;



    @ApiModelProperty(value = "编号", name = "code",  required = true)
    private String code;

    @ApiModelProperty(value = "名称", name = "name",  required = true)
    private String name;

    @ApiModelProperty(value = "注释", name = "remarks",  required = true)
    private String remarks;

    @ApiModelProperty(value = "字段类别（中文）", name = "chineseName",  required = true)
    private String chineseName;

    @ApiModelProperty(value = "排序标识", name = "orderCode",  required = true)
    private Integer orderCode;

    @ApiModelProperty(value = "是否常用", required = true)
    private String isCommonlyUsed;



    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
