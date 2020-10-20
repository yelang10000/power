package com.sun.power.modules.system.dictionary.controller;


import com.sun.power.core.common.controller.BaseController;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;
import com.sun.power.core.exception.PowerException;
import com.sun.power.modules.system.dictionary.service.impl.DictionaryManagementServiceImpl;
import com.sun.power.modules.system.dictionary.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : 贾涛
 * @date : 2019/4/22  14:23
 */
@Api(value = "/dictionary", tags = "系统管理:字典管理")
@RestController()
@RequestMapping("/powers/api/v1")
public class DictionaryManagementController extends BaseController {
    @Autowired
    private DictionaryManagementServiceImpl fieldManagementService;

    /**
     * 新增字段
     * @param fieldCreateVO
     * @param baseRequestVo
     */
    @ApiOperation(value = "新增字段信息", notes = "作者：贾涛", httpMethod = "POST")
    @PostMapping("/dictionary")
    @ResponseBody
    public void addField(@RequestBody DictionaryAdd fieldCreateVO,
                         BaseRequestVo baseRequestVo) {
        if (null == fieldCreateVO || null == baseRequestVo) {
            throw new PowerException("插入失败");
        } else if (null == baseRequestVo.getRequestOrgId()) {
            throw new PowerException("插入失败");
        } else if (null == baseRequestVo.getRequestUserId()) {
            throw new PowerException("缺少当前用户id");
        }
        fieldManagementService.insertItem(fieldCreateVO, baseRequestVo);
    }

    @ApiOperation(value = "新增字典信息(关系表)", notes = "作者：贾涛", httpMethod = "POST")
    @PostMapping("/dictionary/relation")
    @ResponseBody
    public void insertField(@RequestBody DictionaryAdd fieldCreateVO,
                         BaseRequestVo baseRequestVo) {

        fieldManagementService.insertRelation(fieldCreateVO, baseRequestVo);
    }


    /**
     * 删除字段
     * @param fieldDeleteVO
     * @param baseRequestVo
     */
    @ApiOperation(value = "删除字段信息", notes = "作者：贾涛", httpMethod = "DELETE")
    @DeleteMapping("/dictionary")
    @ResponseBody
    public void deleteField(@RequestBody DictionaryDelete fieldDeleteVO,
                            BaseRequestVo baseRequestVo) {
        if (null == fieldDeleteVO || null == baseRequestVo) {
            throw new PowerException( "删除失败");
        } else if (null == baseRequestVo.getRequestOrgId()) {
            throw new PowerException("删除失败");
        } else if (null == baseRequestVo.getRequestUserId()) {
            throw new PowerException( "删除失败");
        }
        fieldManagementService.deleteByIds(fieldDeleteVO, baseRequestVo);
    }

    @ApiOperation(value = "删除字典信息(关系表)", notes = "作者：贾涛", httpMethod = "DELETE")
    @DeleteMapping("/dictionary/relation")
    @ResponseBody
    public void deleteFieldRelation(@RequestBody DictionaryDelete fieldDeleteVO,
                            BaseRequestVo baseRequestVo) {

        fieldManagementService.deleteRelationByIds(fieldDeleteVO, baseRequestVo);
    }

    /**
     * 修改字段
     * @param fieldUpdateVO
     * @param baseRequestVo
     */
    @ApiOperation(value = "修改字段信息", notes = "作者：贾涛", httpMethod = "PUT")
    @PutMapping("/dictionary")
    @ResponseBody
    public void updateField(@RequestBody DictionaryUpdate fieldUpdateVO,
                            BaseRequestVo baseRequestVo,String userId) {
        if (null == fieldUpdateVO || null == baseRequestVo) {
            throw new PowerException( "修改失败");
        } else if (null == baseRequestVo.getRequestOrgId()) {
            throw new PowerException("修改失败");
        } else if (null == baseRequestVo.getRequestUserId()) {
            throw new PowerException( "修改失败");
        }
        fieldManagementService.putItemById(userId,fieldUpdateVO, baseRequestVo);
    }

    /**
     * 根据条件查询字段
     * @param fieldQueryVO
     * @return
     */
    @ApiOperation(value = "条件查询字段信息", notes = "作者：贾涛", httpMethod = "GET")
    @GetMapping("/dictionary")
    @ResponseBody
    public List<DictionaryResult> getFields(DictionaryQuery fieldQueryVO) {
        if (null == fieldQueryVO ) {
            throw new PowerException( "查询失败");
        }
        return  fieldManagementService.findItems1(fieldQueryVO);
    }

    @ApiOperation(value = "条件查询字典信息(关系表)", notes = "作者：贾涛", httpMethod = "GET")
    @GetMapping("/dictionary/relation")
    @ResponseBody
    public ResponseEntity<PageBean<Relation>> selectFields(DictionaryQuery fieldQueryVO) {
        if (null == fieldQueryVO ) {
            throw new PowerException("查询失败");
        }
        return success(fieldManagementService.selectItems(fieldQueryVO));
    }

    /**
     * 根据id查询字段
     * @param code
     * @param baseRequestVo
     * @return
     */
    @ApiOperation(value = "根据code查询字段信息", notes = "作者：贾涛", httpMethod = "GET")
    @GetMapping("/dictionary/{code}")
    @ResponseBody
    public ResponseEntity<DictionaryResult> getFieldsById(@PathVariable(value = "code") String code,
                                                          BaseRequestVo baseRequestVo) {
        if (null == baseRequestVo) {
            throw new PowerException( "查询失败");
        }
        return success(fieldManagementService.findById(code, baseRequestVo));
    }


}
