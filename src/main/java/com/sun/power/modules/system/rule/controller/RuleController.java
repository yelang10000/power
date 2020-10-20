package com.sun.power.modules.system.rule.controller;

/**
 * @Author 贾涛
 * @Date 2020/10/19 15:53
 * @Version 1.0
 */

import com.sun.power.core.common.entity.BaseDeleteRequestBodyVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.modules.system.rule.dto.AddRuleVo;
import com.sun.power.modules.system.rule.dto.ResultRuleVo;
import com.sun.power.modules.system.rule.dto.UpdateRuleVo;
import com.sun.power.modules.system.rule.service.RuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value="/Rule",tags="系统管理:菜单管理")
@Slf4j
@RestController()
@RequestMapping("/powers/api/{version}/rule")
public class RuleController {
    @Autowired
    private RuleService ruleService;

    /***
     * 新增权限信息
     * @param requestVo
     */
    @ApiOperation(value = "新增菜单信息", notes = "作者：贾涛，最后更新时间：2019/04/23", httpMethod = "POST")
    @PostMapping("")
    public void addRule(@RequestBody AddRuleVo requestVo, BaseRequestVo baseRequestVo){
        requestVo.setCreateUserId(baseRequestVo.getRequestUserId());
        requestVo.setCreateOrgId(baseRequestVo.getRequestOrgId());
        ruleService.insertItem(requestVo,baseRequestVo);
    }

    /***
     * 获取所有权限信息
     * @param baseRequestVo
     */
    @ApiOperation(value = "获取所有菜单信息", notes = "作者：贾涛，最后更新时间：2019/04/24", httpMethod = "GET")
    @GetMapping("")
    public List<ResultRuleVo> selectAllRule(BaseRequestVo baseRequestVo){

        return  ruleService.selectAllRule();
    }

    /***
     * 批量逻辑删除权限信息
     * @param
     */
    @ApiOperation(value = "批量逻辑删除菜单信息", notes = "作者：贾涛，最后更新时间：2019/04/24", httpMethod = "DELETE")
    @DeleteMapping("")
    public void deleteByIds(@RequestBody BaseDeleteRequestBodyVO baseDeleteRequestBodyVO, BaseRequestVo baseRequestVo){
        ruleService.deleteByIds(baseDeleteRequestBodyVO,baseRequestVo);
    }

    /**
     * 修改权限信息
     * @param requestVo
     * @param baseRequestVo
     */
    @ApiOperation(value = "根据id修改菜单信息", notes = "作者：贾涛，最后更新时间：2019/04/24",httpMethod = "PUT")
    @PutMapping("/{id}")
    public void updateRule(@PathVariable(value = "id",required = true) String id , @RequestBody UpdateRuleVo requestVo, BaseRequestVo baseRequestVo){
        requestVo.setUpdateUserId(baseRequestVo.getRequestUserId());
        ruleService.putItemById(id,requestVo,baseRequestVo);
    }

    /**
     * 通过url查询菜单信息
     * @param url
     * @return
     */
    @ApiOperation(value = "通过url查询菜单信息", notes = "作者：贾涛，最后更新时间：2019/04/24", httpMethod = "GET")
    @GetMapping("/find/{url}")

    public ResultRuleVo findItemByUrl(@PathVariable(value = "url",required = true)  String url, BaseRequestVo baseRequestVo){
        return  ruleService.findItemByUrl(url);
    }
}
