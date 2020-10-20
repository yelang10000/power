package com.sun.power.core.shiro.factory.Impl;


import com.sun.power.core.shiro.factory.IConstantFactory;
import com.sun.power.core.utils.SpringContextHolder;
import com.sun.power.core.utils.ToolUtil;
import com.sun.power.modules.system.role.dao.RoleMapper;
import com.sun.power.modules.system.role.entity.Role;
import com.sun.power.modules.system.rule.dao.RuleMapper;
import com.sun.power.modules.system.user.dao.UserMapper;
import com.sun.power.modules.system.user.entity.User;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 常量的生产工厂
 *
 * @author 贾涛
 * @Date	 2019-4-2
 */
@Component
@DependsOn("springContextHolder")
public class ConstantFactory implements IConstantFactory {

    private UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);
    private RoleMapper roleMapper = SpringContextHolder.getBean(RoleMapper.class);
    private RuleMapper ruleMapper = SpringContextHolder.getBean(RuleMapper.class);

    public static IConstantFactory me() {

        return SpringContextHolder.getBean("constantFactory");
    }

    /**
     * 根据用户id获取用户名称
     *
     * @author 贾涛
     * @Date 2017/5/9 23:41
     */
    @Override
    public String getUserNameById(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null) {
            return user.getUserName();
        } else {
            return "--";
        }
    }



    /**
     * 根据用户id获取用户账号
     *
     * @author 贾涛
     * @date 2017年5月16日21:55:371
     */
    @Override
    public String getUserAccountById(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null) {
            return user.getUserName();
        } else {
            return "--";
        }
    }

    /**
     * 通过角色id获取菜单资源
     */
    @Override
    public List<String> getMenuByRoleId(String roleId) {
        System.out.println(roleId);
        return roleMapper.selectRuleByRoleId(roleId);

    }

    /**
     * 通过角色id获取角色名称
     */
    @Override
    public String getRoleName(String roleIds) {
        return null;
    }

    /**
     * 通过角色id获取角色名称
     */
    @Override
    public String getSingleRoleName(String roleId) {

        if ("0".equalsIgnoreCase(roleId)) {
            return "--";
        }
        Role roleObj = roleMapper.selectById(roleId);
        if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getRoleName())) {
            return roleObj.getRoleName();
        }
        return "";
    }

    @Override
    public String getSingleRoleTip(String roleId) {
        return null;
    }

    @Override
    public String getDeptName(Integer deptId) {
        return null;
    }

    @Override
    public String getMenuNames(String menuIds) {
        return null;
    }

    @Override
    public String getMenuName(Long menuId) {
        return null;
    }

    @Override
    public String getMenuNameByCode(String code) {
        return null;
    }

    @Override
    public String getDictName(Integer dictId) {
        return null;
    }

    @Override
    public String getNoticeTitle(Integer dictId) {
        return null;
    }

    @Override
    public String getDictsByName(String name, Integer val) {
        return null;
    }

    @Override
    public String getSexName(Integer sex) {
        return null;
    }

    @Override
    public String getStatusName(Integer status) {
        return null;
    }

    @Override
    public String getMenuStatusName(Integer status) {
        return null;
    }

    @Override
    public String getCacheObject(String para) {
        return null;
    }

    @Override
    public List<Integer> getSubDeptId(Integer deptid) {
        return null;
    }

    @Override
    public List<Integer> getParentDeptIds(Integer deptid) {
        return null;
    }



}
