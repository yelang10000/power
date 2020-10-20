package com.sun.power.modules.system.rule.service;



import com.sun.power.core.common.entity.BaseDeleteRequestBodyVO;
import com.sun.power.core.common.service.Impl.BaseService;
import com.sun.power.modules.system.rule.dto.AddRuleVo;
import com.sun.power.modules.system.rule.dto.QueryAllRuleVo;
import com.sun.power.modules.system.rule.dto.ResultRuleVo;
import com.sun.power.modules.system.rule.dto.UpdateRuleVo;

import java.util.List;

/**
 * @author : 贾涛
 * @date : 2019/4/10  12:35
 */
public interface RuleService extends BaseService<AddRuleVo, BaseDeleteRequestBodyVO, UpdateRuleVo, QueryAllRuleVo, ResultRuleVo> {
    /**
     * 获取所有权限信息
     * @return map
     */
    List<ResultRuleVo> selectAllRule();

    /**
     * 通过权限id查询权限所有信息
     * @param url
     * @return rule
     */
    ResultRuleVo findItemByUrl(String url);
}
