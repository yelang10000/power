package com.sun.power.modules.system.dictionary.vo;


import com.sun.power.core.aop.mysql.MysqlQueryFieldHandle;
import com.sun.power.core.common.entity.BaseRequestVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : 贾涛
 * @date : 2019/4/22  14:28
 */
@ApiModel(value = "字段查询入参", description = "用于查询字段")
@Data
public class DictionaryQuery  extends BaseRequestVo {
//    @ApiModelProperty(value = "查询类别（dict-查询字典信息,field-查询字段信息：" +
//            "如果为dict，则返回非重复的字典信息，否则返回详细的字段信息）", name = "queryType", required = false, example = "dict")
//    private String queryType;

    @MysqlQueryFieldHandle
    @ApiModelProperty(value = "字段类别（中文）", name = "chineseName", required = false)
    private String chineseName;
    @MysqlQueryFieldHandle
    @ApiModelProperty(value = "字段类别（英文）", name = "name", required = false)
    private String name;

    @ApiModelProperty(value = "currentPage", required = false)
    private int currentPage = 1;

    @ApiModelProperty(value = "pageSize", required = false)
    private int pageSize = 20;
}
