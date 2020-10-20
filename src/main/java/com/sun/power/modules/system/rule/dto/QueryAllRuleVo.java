package com.sun.power.modules.system.rule.dto;


import com.sun.power.core.common.entity.BaseRequestVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author : caoxin
 * @Date: 2019/4/18
 * @Description:
 * createUserId 创建用户id
 * updateUserId 更新用户id
 * createOrgId 创建组织Id
 */
@Data
public class QueryAllRuleVo extends BaseRequestVo {

    private String id;

    private String parentId;

    private String ruleName;

    private String remark;

    private String url;

    private String createUserId;

    private String updateUserId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDeleted;

    private String createOrgId;

   private List<QueryAllRuleVo> ruleList;

   public QueryAllRuleVo(){}

    public QueryAllRuleVo(String id, String parentRuleId, String ruleName, String remark, String url, String createUserId, String updateUserId, Date gmtCreate, Date gmtModified, Byte isDeleted, String createOrgId, List<QueryAllRuleVo> ruleList) {
        this.id = id;
        this.parentId = parentRuleId;
        this.ruleName = ruleName;
        this.remark = remark;
        this.url = url;
        this.createUserId = createUserId;
        this.updateUserId = updateUserId;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDeleted = isDeleted;
        this.createOrgId = createOrgId;
        this.ruleList = ruleList;
    }
}
