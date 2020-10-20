package com.sun.power.modules.system.organization.controller;

import com.sun.power.core.common.entity.BaseDeleteRequestBodyVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;
import com.sun.power.modules.system.organization.dto.OrganizationDetails;
import com.sun.power.modules.system.organization.dto.OrganizationRequestBodyVO;
import com.sun.power.modules.system.organization.dto.OrganizationSelectQueryVO;
import com.sun.power.modules.system.organization.service.OrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 贾涛
 * @Date 2020/10/19 15:33
 * @Version 1.0
 */
@Api(value="/organization",tags="系统管理:单位管理")
@Slf4j
@RestController()
@RequestMapping("/powers/api/v1/organization")
public class OrganizationController {

    @Autowired
    OrganizationService organizationService;


    /***
     * 新增组织信息
     * @param requestVo
     */
    @ApiOperation(value = "新增组织信息", notes = "作者：贾涛，最后更新时间：2019/04/17", httpMethod = "POST")
    @PostMapping("")
    public void add(@RequestBody OrganizationRequestBodyVO requestVo, BaseRequestVo baseRequestVo){
        organizationService.insertItem(requestVo,baseRequestVo);
    }

    /**
     * 根据组织id查询组织信息
     * @param id
     * @param baseRequestVo
     * @return
     */
    @ApiOperation(value = "根据单位id查询单位信息", notes = "作者：贾涛，最后更新时间：2019/04/18", httpMethod = "GET")
    @GetMapping("/{id}")
    @ResponseBody
    public OrganizationDetails findByOrgId(@PathVariable(value = "id", required = true) String id, BaseRequestVo baseRequestVo) {
        return organizationService.findItemById(id,baseRequestVo);
    }

    /**
     * 根据组织id修改组织信息
     * @param requestVO
     * @param id
     * @param baseRequestVO
     */
    @ApiOperation(value = "根据组织id修改组织信息", notes = "作者：贾涛，最后更新时间：2019/04/18", httpMethod = "PUT")
    @PutMapping("/{id}")
    public void update(@RequestBody OrganizationRequestBodyVO requestVO, @PathVariable(value = "id", required = true) String id, BaseRequestVo baseRequestVO){
        organizationService.putItemById(id,requestVO, baseRequestVO);
    }


    /***
     * 删除组织信息
     * @param requestVO
     * @param baseRequestVO
     */
    @ApiOperation(value = "删除组织信息", notes = "作者：贾涛，最后更新时间：2019/04/17", httpMethod = "DELETE")
    @DeleteMapping("")
    public void delete(@RequestBody BaseDeleteRequestBodyVO requestVO, BaseRequestVo baseRequestVO){
        organizationService.deleteByIds(requestVO, baseRequestVO);
    }

    /***
     * 根据条件查询组织信息
     * @param requestVo
     * @return
     */
    @ApiOperation(value = "根据条件查询组织信息", notes = "作者：贾涛，最后更新时间：2019/04/19", httpMethod = "GET")
    @GetMapping("")
    @ResponseBody
    public PageBean<OrganizationDetails> getList(OrganizationSelectQueryVO requestVo){
        return organizationService.findItems(requestVo);
    }
    /**
     * 根据组织id查询直属子组织信息
     * @param
     * @return
     */
    @ApiOperation(value = "根据组织id查询直属子组织信息", notes = "作者：贾涛，最后更新时间：2019/07/30", httpMethod = "GET")
    @GetMapping("/directly-child")
    @ResponseBody
    public PageBean<OrganizationDetails> findOrgById(OrganizationSelectQueryVO organizationSelectQueryVO) {
        return organizationService.findOrgById(organizationSelectQueryVO);
    }
}
