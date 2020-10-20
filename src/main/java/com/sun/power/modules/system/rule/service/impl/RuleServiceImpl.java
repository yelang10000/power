package com.sun.power.modules.system.rule.service.impl;


import com.sun.power.core.common.entity.BaseDeleteQueryVO;
import com.sun.power.core.common.entity.BaseDeleteRequestBodyVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;
import com.sun.power.core.exception.PowerException;
import com.sun.power.modules.system.rule.dao.RuleMapper;
import com.sun.power.modules.system.rule.dto.AddRuleVo;
import com.sun.power.modules.system.rule.dto.QueryAllRuleVo;
import com.sun.power.modules.system.rule.dto.ResultRuleVo;
import com.sun.power.modules.system.rule.dto.UpdateRuleVo;
import com.sun.power.modules.system.rule.entity.Rule;
import com.sun.power.modules.system.rule.service.RuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : caoxin
 * @date : 2019/4/23  12:36
 */
@Slf4j
@Service
public class RuleServiceImpl implements RuleService {

    @Autowired
    private RuleMapper ruleMapper;

    /***
     * 新增权限信息
     * @param requestVo
     * @param baseRequestVo
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void insertItem(AddRuleVo requestVo, BaseRequestVo baseRequestVo) {
        //根据权限名称查看是否存在
        if(ruleMapper.findRuleByName(requestVo) != 0){
            throw new PowerException("已存在");
        }
        //如果parentId为空  就是添加一级权限
        if(("00").equals(requestVo.getParentRuleId()) || requestVo.getParentRuleId() == null ){
            //查找数据库所有信息
            Rule lastRule = ruleMapper.selectLastRule();
            //如果为空  则默认id 为01  parentId=0
            if(lastRule == null){
                requestVo.setId("01");
                requestVo.setUrl("01");
                requestVo.setParentRuleId("00");
                ruleMapper.insert(requestVo);
            }else{
                // 如果不为空按parentId = 0查询倒叙排序取一条数据拿到id 进行添加
                Rule stairMaxRuleId = ruleMapper.selectStairId();
                String ruleId;
                if(Integer.parseInt(stairMaxRuleId.getId()) < 9){
                    ruleId = "0" + String.valueOf(Integer.parseInt(stairMaxRuleId.getId())+1);
                }else{
                    ruleId = String.valueOf(Integer.parseInt(stairMaxRuleId.getId())+1);
                }
                requestVo.setId(ruleId);
                requestVo.setUrl(ruleId);
                requestVo.setParentRuleId("00");
                ruleMapper.insert(requestVo);
            }
        }else{
            String orgId = makerRuleId(requestVo.getParentRuleId());
            requestVo.setId(orgId);
            requestVo.setUrl(orgId);
            requestVo.setParentRuleId(requestVo.getParentRuleId());
            ruleMapper.insert(requestVo);
        }
    }

    /***
     * 批量逻辑删除权限信息
     * @param requestVo
     * @param baseRequestVo
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteByIds(BaseDeleteRequestBodyVO requestVo, BaseRequestVo baseRequestVo) {

        BaseDeleteRequestBodyVO baseDeleteRequestBodyVO = (BaseDeleteRequestBodyVO) requestVo;
        if(baseDeleteRequestBodyVO.getIds().size() == 0){
            throw new PowerException("请选择");
        }else {
            for(String id : baseDeleteRequestBodyVO.getIds()){
                    if(ruleMapper.selectSonForParentId(id).size() != 0){
                        throw new PowerException("已存在子权限，不可删除");
                    }
            }
            BaseDeleteQueryVO baseDeleteQueryVO = new BaseDeleteQueryVO();
            baseDeleteQueryVO.setGmtModified(new Date());
            baseDeleteQueryVO.setIds(baseDeleteRequestBodyVO.getIds());
            baseDeleteQueryVO.setUpdateUserId(baseRequestVo.getRequestUserId());
            ruleMapper.deleteByIds(baseDeleteQueryVO);
        }

    }

    /**
     * 修改权限信息
     * @param requestVo
     * @param baseRequestVo
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void putItemById(String id, UpdateRuleVo requestVo, BaseRequestVo baseRequestVo) {
        requestVo.setId(id);
        if(("00").equals(requestVo.getParentRuleId())) {
            ruleMapper.updateFirstRule(requestVo);
        }else{
            String ruleId = makerRuleId(requestVo.getParentRuleId());
            requestVo.setUrl(ruleId);
            requestVo.setParentRuleId(requestVo.getParentRuleId());
            ruleMapper.updateSecondRule(requestVo);
        }
    }

    @Override
    public PageBean<ResultRuleVo> findItems(QueryAllRuleVo requestVo) {
        return null;
    }

    /**
     * 获取所有权限信息
     * @return map
     */
    @Override
    public List<ResultRuleVo> selectAllRule(){
        List<ResultRuleVo> stairRules = ruleMapper.selectAllStair();
        List<ResultRuleVo> allRuleVosList = new  ArrayList<ResultRuleVo>();
        for(ResultRuleVo stair : stairRules){
            allRuleVosList.add(stair);
        }
        for(ResultRuleVo stair : allRuleVosList){
            stair.setRoutes(
            getChild(stair.getId(),ruleMapper.selectChildForParentId(stair.getId())));
        }
        return allRuleVosList;
    }

    /**
     * 根据id获取权限信息
     * @return map
     */
    @Override
    public ResultRuleVo findItemById(String userId, BaseRequestVo baseRequestVo) {
        return ruleMapper.findItemById(userId);
    }


    /***
     * 生成组织id
     * @param parentEmployerId
     * @return
     */
    private String makerRuleId(String parentEmployerId) {
        String orgId;
        Rule chiledRule = ruleMapper.selectChildForParentIdGetOne(parentEmployerId);
        if (chiledRule != null) {
            String[] ruleIdSplit = chiledRule.getId().split("-");
            int ruleId = Integer.parseInt((ruleIdSplit[(ruleIdSplit.length-1)]));
            if (ruleId < 9) {
                orgId = parentEmployerId + "-" + "0" + String.valueOf(ruleId + 1);
            } else {
                orgId = parentEmployerId + "-" + String.valueOf(ruleId + 1);
            }
        }else{
            orgId = parentEmployerId + "-01";
        }
        return orgId;
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
                    for (ResultRuleVo menu1 : childList) {
                        menu1.setRoutes(getChild(menu1.getId(), rootMenu));
                        if (childList.size() == 0) {
                            return null;
                        }
                    }
                }
        }
        return childList;
    }

    /**
     * 通过url查询菜单信息
     * @param url
     * @return
     */
    @Override
    public ResultRuleVo findItemByUrl(String url){
        String parentId = ruleMapper.selectParentId(url);
        List<ResultRuleVo> allRuleVosList = new  ArrayList<ResultRuleVo>();
        if(parentId == null || "00".equals(parentId ) ){
            ResultRuleVo resultRuleVo = ruleMapper.selectRuleByUrl(url);

            List<ResultRuleVo> resultRuleVoList =  ruleMapper.findItemsByUrl(resultRuleVo.getId());
            resultRuleVo.setRoutes(resultRuleVoList);
            return resultRuleVo;
        }
        return ruleMapper.findItemByUrl(url);

    }
}
