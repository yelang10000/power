package com.sun.power.modules.system.role.controller;

import com.sun.power.core.common.entity.BaseDeleteRequestBodyVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;
import com.sun.power.core.utils.UUIDGenerator;
import com.sun.power.modules.system.role.dto.*;
import com.sun.power.modules.system.role.entity.Role;
import com.sun.power.modules.system.role.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 贾涛
 * @Date 2020/10/19 15:41
 * @Version 1.0
 */
@Api(value="/Role",tags="系统管理:角色管理/角色授权")
@Slf4j
@RestController()
@RequestMapping("/powers/api/v1/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 查询列表/按名称查询
     * @param requestVo
     * @return
     */
    @ApiOperation(value = "查询列表",notes = "作者：贾涛，最后更新时间：2019/04/17",httpMethod = "GET")
    @GetMapping("")
    public PageBean<Role>  findAllRole(QueryRoleVo requestVo){
        return roleService.findItems(requestVo);

    }

    /**
     * 新增角色
     * @param requestVo
     * @param baseRequestVo
     * @return
     */
    @ApiOperation(value = "新增角色",notes = "作者：贾涛，最后更新时间：2019/04/17",httpMethod = "POST")
    @PostMapping("")
    public void insertRole(@RequestBody AddRoleVo requestVo, BaseRequestVo baseRequestVo){
        if(roleService.roleNameOnlyCheckout(requestVo.getRoleName(),baseRequestVo)) {
            requestVo.setId(UUIDGenerator.generate());
            requestVo.setCreateUserId(baseRequestVo.getRequestUserId());
            requestVo.setCreateOrgId(baseRequestVo.getRequestOrgId());
            roleService.insertItem(requestVo, baseRequestVo);
        }
    }

    /**
     * 修改角色
     * @param requestVo
     * @param baseRequestVo
     * @return
     */
    @ApiOperation(value = "修改角色",notes = "作者：贾涛，最后更新时间：2019/04/17",httpMethod = "PUT")
    @PutMapping("/{id}")
    public void updateRole(@PathVariable(value = "id",required = true)String id, @RequestBody UpdateRoleVo requestVo, BaseRequestVo baseRequestVo){
        requestVo.setUpdateUserId(baseRequestVo.getRequestUserId());
        roleService.putItemById(id,requestVo, baseRequestVo);
    }

    /**
     * 逻辑批量删除角色
     * @param baseDeleteRequestBodyVO
     * @param baseRequestVo
     * @return
     */
    @ApiOperation(value = "逻辑删除角色",notes = "作者：贾涛，最后更新时间：2019/04/17",httpMethod = "DELETE")
    @DeleteMapping("")
    public void deleteByIds (@RequestBody BaseDeleteRequestBodyVO baseDeleteRequestBodyVO, BaseRequestVo baseRequestVo) {
        roleService.deleteByIds(baseDeleteRequestBodyVO, baseRequestVo);
    }

    /**
     * 根据角色id查询角色信息
     * @param id
     * @param baseRequestVo
     * @return
     */
    @ApiOperation(value = "根据角色id查询角色信息",notes = "作者：贾涛，最后更新时间：2019/04/17",httpMethod = "GET")
    @GetMapping("/{id}")
    public Role findItemById(@PathVariable(value = "id",required = true) String id, BaseRequestVo baseRequestVo){
        return roleService.findItemById(id,baseRequestVo);
    }


    /**
     * 角色添加权限
     * @param baseRequestVo
     * @param roleRule
     * @return
     */
    @ApiOperation(value = "角色添加权限",notes = "作者：贾涛，最后更新时间：2019/04/17",httpMethod = "POST")
    @PostMapping("/rule")
    public void roleAddRule(BaseRequestVo baseRequestVo, @RequestBody RoleAddRuleVo roleRule){
        roleRule.setCreateUserId(baseRequestVo.getRequestUserId());
        roleRule.setCreateOrgId(baseRequestVo.getRequestOrgId());
        roleService.roleAddRule(roleRule);
    }

    /**
     * 角色删除权限
     * @param baseRequestVo
     * @param roleRule
     * @return
     */
   @DeleteMapping("/rule")
    public void roleDeleteRule(BaseRequestVo baseRequestVo, @RequestBody RoleDeleteRuleVo roleRule){
        roleRule.setUpdateUserId(baseRequestVo.getRequestUserId());
        roleService.roleDeleteRule(roleRule);
    }

    /**
     * 根据角色获取菜单信息
     * @param baseRequestVo
     * @param roleId
     * @return
     */
    @ApiOperation(value = "根据角色获取菜单信息",notes = "作者：贾涛，最后更新时间：2019/04/17",httpMethod = "GET")
    @GetMapping("/{roleId}/selectRuleByRoleId")
    public List<String> selectRuleByRoleId(@PathVariable(value = "roleId",required = true) String roleId, BaseRequestVo baseRequestVo){
        return roleService.selectRuleByRoleId1(roleId);
    }

    /**
     * 根据角色修改权限
     * @param baseRequestVo
     * @param roleDeleteRuleVo
     * @return
     */
    @ApiOperation(value = "根据角色修改权限",notes = "作者：贾涛，最后更新时间：2019/04/17",httpMethod = "POST")
    @PostMapping("/update_rule")
    public void updateRuleByRoleId(@RequestBody RoleDeleteRuleVo roleDeleteRuleVo, BaseRequestVo baseRequestVo){
        roleService.updateRuleByRoleId(roleDeleteRuleVo,baseRequestVo);
    }


}
