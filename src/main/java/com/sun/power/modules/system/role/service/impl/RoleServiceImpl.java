package com.sun.power.modules.system.role.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.sun.power.core.aop.mysql.MysqlQueryFieldHandleAspect;
import com.sun.power.core.common.entity.BaseDeleteQueryVO;
import com.sun.power.core.common.entity.BaseDeleteRequestBodyVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;
import com.sun.power.core.exception.PowerException;
import com.sun.power.modules.system.role.dao.RoleMapper;
import com.sun.power.modules.system.role.dao.RoleUserMapper;
import com.sun.power.modules.system.role.dto.*;
import com.sun.power.modules.system.role.entity.Role;
import com.sun.power.modules.system.role.service.RoleService;
import com.sun.power.modules.system.rule.dto.ResultRuleVo;
import com.sun.power.modules.system.user.dto.AddUserVo;
import com.sun.power.modules.system.user.dto.UpdateUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : 贾涛
 * @date : 2019/4/10  10:30
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    private String generalManager = "402882866a4dba7f016a4dba84d1";
    private String worker = "402882866a4dba7f016a4dbbba05";
    private String admin = "admin";

    /***
     * 新增角色
     * @param requestVo
     * @param baseRequestVo
     * @return
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void insertItem(AddRoleVo requestVo, BaseRequestVo baseRequestVo) {
        if(!"1000".equals(baseRequestVo.getRequestOrgId())){
            if(findItemById(generalManager,baseRequestVo).getRoleName().equals(requestVo.getRoleName())
                    || findItemById(worker,baseRequestVo).getRoleName().equals(requestVo.getRoleName())){
                throw new PowerException("此名称已占用，请重新输入");
            }
        }
        if(requestVo.getRoleName() == null){
            throw new PowerException("输入角色名称");
        }
        if (baseRequestVo==null){
            throw new PowerException("基本参数为null");
        }
        roleMapper.insertRole(requestVo);
    }

    /***
     * 逻辑批量删除角色
     * @param requestVo
     * @param baseRequestVo
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteByIds(BaseDeleteRequestBodyVO requestVo, BaseRequestVo baseRequestVo) {
        for(String id : requestVo.getIds()){
            if(!admin.equals(baseRequestVo.getRequestUsername())){
                if(generalManager.equals(id) || worker.equals(id)){
                    throw new PowerException("通用角色不可删除");
                }
            }
            if(isExistUser(id,baseRequestVo.getRequestOrgId()) == false){
                throw new PowerException("角色下存在用户");
            }
        }
        BaseDeleteQueryVO baseDeleteQueryVO = new BaseDeleteQueryVO();
        baseDeleteQueryVO.setGmtModified(new Date());
        baseDeleteQueryVO.setIds(requestVo.getIds());
        baseDeleteQueryVO.setUpdateUserId(baseRequestVo.getRequestUserId());
        roleMapper.deleteRoleByIds(baseDeleteQueryVO);
    }

    /***
     * 根据id修改角色
     * @param requestVo
     * @param
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void putItemById(String ruleId, UpdateRoleVo requestVo, BaseRequestVo baseRequestVo){
        if(!admin.equals(baseRequestVo.getRequestUsername())){
            if(generalManager.equals(ruleId) || worker.equals(ruleId)){
                throw new PowerException("无权限不可修改");
            }
        }
        if(!findItemById(ruleId,baseRequestVo).getRoleName().equals(requestVo.getRoleName())){
            roleNameOnlyCheckout(requestVo.getRoleName(),baseRequestVo);
        }

        requestVo.setId(ruleId);
        roleMapper.updateUser(requestVo);
    }

    /***
     * 查询角色列表、模糊查询
     * @param requestVo
     * @return
     */
    @Override
    @MysqlQueryFieldHandleAspect
    public PageBean<Role> findItems(QueryRoleVo requestVo) {
        Integer currentPage = requestVo.getCurrentPage();
        Integer pageSize = requestVo.getPageSize();
        Page page = PageHelper.startPage(currentPage == null ? 1 : currentPage,
                pageSize == null ? 10 : pageSize);
        List<Role> roleList = roleMapper.selectAllRole(requestVo);
        if(!"1000".equals(requestVo.getRequestOrgId())){

            roleList.add(roleMapper.selectById(worker));
            Role role = roleMapper.selectById(generalManager);
            roleList.add(role);
        }

        PageBean<Role> pageData = new PageBean<>(currentPage == null ? 1 : currentPage, pageSize == null ? 10 : pageSize, new Long(page.getTotal()).intValue());
        pageData.setItems(roleList);
        return pageData;
    }

    /**
     * 根据id查询角色信息
     * @param userId
     * @param baseRequestVo
     * @return
     */
    @Override
    public Role findItemById(String userId, BaseRequestVo baseRequestVo) {
        return roleMapper.selectById(userId);
    }

    /***
     * 添加人员时，添加roel_user信息
     * @param record
     * @return
     */
    @Override
    public void insertRoleUser(AddUserVo record){

        roleUserMapper.insertRoleUser(record);

    }
    /***
     * 编辑人员时，编辑roel_user信息
     * @param record
     * @return
     */
    @Override
    public void updateRoleUser(UpdateUserVo record){
        roleUserMapper.updateRoleUser(record);
    }

    /***
     * 校验角色名称唯一
     * @param roleName
     * @return
     */
    @Override
    public boolean roleNameOnlyCheckout(String roleName,BaseRequestVo baseRequestVo){
        boolean isExist = true;
        String getRoleName = roleMapper.roleNameList(roleName,baseRequestVo);

            if(roleName.equals(getRoleName)){
                isExist = false;
                throw new PowerException("角色名称已存在");
            }
        return isExist;
    }

    /***
     * 角色添加权限
     * @param roleRule
     * @param
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void roleAddRule(RoleAddRuleVo roleRule){
        roleMapper.roleAddRule(roleRule);
    }

    /***
     * 角色删除权限
     * @param roleRule
     * @param
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void roleDeleteRule(RoleDeleteRuleVo roleRule){

        roleMapper.roleDeleteRule(roleRule);
    }

    /***
     * 判断角色下是否存在用户
     * @param roleId
     * @param
     * 'true' 不存在  false 存在
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public boolean isExistUser(String roleId,String orgId){
        boolean notExist = false;
        if(roleMapper.roleHasUser(roleId,orgId).size() == 0){
            notExist = true;
        }
        return notExist;
    }

    /**
     * 根据角色id获取菜单信息
     * @param roleId
     * @return
     */
    @Override
    public List<ResultRuleVo> selectRuleByRoleId(String roleId){
        //nadao
        List<String > ruleIds = roleMapper.selectRuleByRoleId(roleId);
        if(ruleIds.size() == 0){
            return null;
        }
//
//        List<String> stringList=new ArrayList<>();
//        for (Operation operation:roleIds)
//        {
//            stringList.add(operation.getRulerId());
//        }
//        List<ResultRuleVo> stairParentRules = roleMapper.selectParentRuleByrole(stringList,roleId);
//        List<ResultRuleVo> stairRules = roleMapper.selectRuleByrole(stringList,roleId);
        List<ResultRuleVo> stairParentRules = roleMapper.selectParentRuleByrole(ruleIds);
        List<ResultRuleVo> stairRules = roleMapper.selectRuleByrole(ruleIds);

        for(ResultRuleVo stair : stairParentRules){
            stair.setRoutes(getChild(stair.getId(),stairRules));

        }

        return stairParentRules;
    }

    /**
     * 根据角色id获取菜单信息
     * @param roleId
     * @return
     */
    @Override
    public List<String> selectRuleByRoleId1(String roleId){
        List<String > ruleIds = roleMapper.selectRuleByRoleId(roleId);
        return ruleIds;
    }

    /**
     *递归查询子组织
     * @param id
     * @param rootMenu
     * @return
     */
    private List<ResultRuleVo> getChild(String id, List<ResultRuleVo> rootMenu) {

        List<ResultRuleVo> childList = new ArrayList<>();
        for (ResultRuleVo menu : rootMenu) {
            if (menu.getParentId().equals(id)) {
                childList.add(menu);
            }

        }
        // 把子组织的子组织再循环一遍
        for (ResultRuleVo menu : childList) {
            menu.setRoutes(getChild(menu.getId(), rootMenu));
        }
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

    /**
     * 根据角色id修改权限信息
     *  @param roleDeleteRuleVo
     * @return
     */
    @Override
    public void updateRuleByRoleId(RoleDeleteRuleVo roleDeleteRuleVo,BaseRequestVo baseRequestVo){
        if(roleDeleteRuleVo.getIds().size() == 0){
            throw new PowerException("请选择权限");
        }
        if(!admin.equals(baseRequestVo.getRequestUsername())){
            if(generalManager.equals(roleDeleteRuleVo.getRoleId()) || worker.equals(roleDeleteRuleVo.getRoleId())){
                throw new PowerException("通用角色不可修改");
            }
        }
        if(selectRuleByRoleId(roleDeleteRuleVo.getRoleId()) != null){
            roleMapper.roleDeleteUpRule(roleDeleteRuleVo);
        }

        roleDeleteRuleVo.setCreateUserId(baseRequestVo.getRequestUserId());
        roleDeleteRuleVo.setCreateOrgId(baseRequestVo.getRequestOrgId());
        roleMapper.roleAddUpRule(roleDeleteRuleVo);

    }
}
