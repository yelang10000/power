package com.sun.power.modules.system.role.service;



import com.sun.power.core.common.entity.BaseDeleteRequestBodyVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.service.Impl.BaseService;
import com.sun.power.modules.system.role.dto.*;
import com.sun.power.modules.system.role.entity.Role;
import com.sun.power.modules.system.rule.dto.ResultRuleVo;
import com.sun.power.modules.system.user.dto.AddUserVo;
import com.sun.power.modules.system.user.dto.UpdateUserVo;

import java.util.List;

/**
 * @author : 贾涛
 * @date : 2019/4/10  10:30
 */
public interface RoleService extends BaseService<AddRoleVo, BaseDeleteRequestBodyVO, UpdateRoleVo, QueryRoleVo, Role> {

    /***
     * 添加人员时，添加roel_user信息
     * @param record
     * @return
     */
    void insertRoleUser(AddUserVo record);
    /***
     * 编辑人员时，编辑roel_user信息
     * @param record
     * @return
     */
    void updateRoleUser(UpdateUserVo record);

    /***
     * 校验角色名称唯一
     * @param roleName
     * @return
     */
    boolean roleNameOnlyCheckout(String roleName, BaseRequestVo baseRequestVo);
       /***
     * 角色添加权限
     * @param roleRule
     * @param
     */
    void roleAddRule(RoleAddRuleVo roleRule);
    /***
     * 角色删除权限
     * @param roleRule
     * @param
     */
    void roleDeleteRule(RoleDeleteRuleVo roleRule);
    /***
     * 判断角色下是否存在用户
     * @param roleId
     * @param
     * 'true' 不存在  false 存在
     */
    boolean isExistUser(String roleId,String orgId);

    /**
     * 根据角色id获取菜单信息
     * @param roleId
     * @return
     */
    List<ResultRuleVo> selectRuleByRoleId(String roleId);

    List<String> selectRuleByRoleId1(String roleId);

    /**
     * 根据角色id修改权限信息
     * @param roleDeleteRuleVo
     * @return
     */
    void updateRuleByRoleId(RoleDeleteRuleVo roleDeleteRuleVo,BaseRequestVo baseRequestVo);
}
