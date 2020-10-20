package com.sun.power.modules.system.organization.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.power.core.common.constant.SysConstant;
import com.sun.power.core.common.entity.BaseDeleteQueryVO;
import com.sun.power.core.common.entity.BaseDeleteRequestBodyVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;
import com.sun.power.core.exception.PowerException;
import com.sun.power.core.utils.UUIDGenerator;
import com.sun.power.modules.system.organization.dao.OrganizationMapper;
import com.sun.power.modules.system.organization.dto.*;
import com.sun.power.modules.system.organization.entity.Organization;
import com.sun.power.modules.system.organization.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author 贾涛
 * @Date 2020/10/17 10:03
 * @Version 1.0
 */
@Slf4j
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationMapper organizationMapper;

    @Override
    public List<OrganizationDetails> findChildByOrgId(String id, BaseRequestVo baseRequestVo) {
        return null;
    }

    @Override
    public PageBean<OrganizationDetails> findItemsAll(OrganizationSelectQueryVO requestVo) {
        return null;
    }

    @Override
    public PageBean<OrganizationDetails> findItemsAll1(OrganizationSelectQueryVO requestVo) {
        return null;
    }

    @Override
    public List<OrganizationDetails> findDirectlyChildByOrgId(String id, BaseRequestVo baseRequestVo) {
        return null;
    }

    @Override
    public List<OrganizationDetails> getListAll(OrgSelectVO requestVo) {
        return null;
    }

    @Override
    public List<OrgDetails> getListsAll(String orgId) {
        return null;
    }

    /**
     * 根据id查询下级单位
     * @param requestVo
     * @return
     */

    @Override
    public PageBean<OrganizationDetails> findOrgById(OrganizationSelectQueryVO requestVo) {
        log.info("条件查询所有子单位");
        requestVo.setOrgIdForDataSelect(requestVo.getRequestOrgId());
        requestVo.setAllIndex("all");
        requestVo.setDataAuthSql(requestVo.getDataAuthSql().replace("create_org_id","o.id"));
        Page<OrganizationDetails> page = PageHelper.startPage(requestVo.getCurrentPage(), requestVo.getPageSize());
        //条件查询子组织信息
        List<OrganizationDetails> resultList = organizationMapper.findOrgById(requestVo);
        for(OrganizationDetails org:resultList){
            //查询是否存在子单位
            int m = organizationMapper.queryIsSubunit(org.getId());
            if (m ==0 ){
                org.setIsSubunit(0);
            }else {
                org.setIsSubunit(1);
            }
        }
        //分页包装
        PageBean<OrganizationDetails> pageData = new PageBean<>(requestVo.getCurrentPage(), requestVo.getPageSize(), (int)page.getTotal());
        pageData.setItems(resultList);
        return pageData;
    }

    /**
     * 新增组织
     * @param requestVo
     * @param baseRequestVo
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void insertItem(OrganizationRequestBodyVO requestVo, BaseRequestVo baseRequestVo) {
        log.info("start" + baseRequestVo.getRequestOrgId() + "++++++++++++" + baseRequestVo.getRequestUserId());
        //新增前判断组织名是否已存在
//        int m = organizationMapper.findOrganizationByName(requestVo);
//        if (m != 0) {
//            throw new ServiceErrorException("组织名称[" + requestVo.getOrganizationName() + "]已经存在!!!");
//        }
        Organization organization = new Organization();
//        organization.setId(makerOrgId(requestVo.getParentEmployerId()));
        //组织参数初始化
        setInsertOrgVO(requestVo, organization, baseRequestVo);
        //设置组织级别
        organization.setDictRank(organizationMapper.findParentOrgRank(requestVo.getParentEmployerId()).getDictRank() + 1);
        organizationMapper.insert(organization);

    }
    /***
     * 生成组织id
     * @param parentEmployerId
     * @return
     */
    private String makerOrgId(String parentEmployerId) {
        String orgId;
        //查询上级单位的子单位
        Organization organization = organizationMapper.findByIdForChild(parentEmployerId);
        if (organization != null) {
            //组织下已有子单位
            //字符串分割  截取获得后四位
            int organizationId = Integer.parseInt(organization.getId().substring(organization.getId().length() - 4, organization.getId().length()));
            orgId = parentEmployerId + "-" + String.valueOf(organizationId + 1);
        } else {
            //组织下还没子单位
            orgId = parentEmployerId + "-1000";
        }

        return orgId;
    }


    @Override
    public void deleteByIds(BaseDeleteRequestBodyVO requestVo, BaseRequestVo baseRequestVo) {
        for (String id : requestVo.getIds()) {
            //判断组织下是否存在子组织
            Organization organizationList = organizationMapper.findByIdForChild(id);
            if (organizationList != null) {
                //存在子组织
                throw new PowerException("该组织下有组织未删除请先删除组织");
            }
            //判断组织下是否存在人员
            int m = organizationMapper.userCount(id);
            if (m != 0) {
                //存在用户
                throw new PowerException("该组织下已经有工作人员请先清空工作人员再删除组织");
            }

        }
        BaseDeleteQueryVO baseDeleteQueryVO = new BaseDeleteQueryVO();
        baseDeleteQueryVO.setGmtModified(new Date());
        baseDeleteQueryVO.setIds(requestVo.getIds());
        baseDeleteQueryVO.setUpdateUserId(baseRequestVo.getRequestOrgId());
        //删除组织信息
       int i= organizationMapper.deleteByIds(baseDeleteQueryVO);

    }
    /***
     * 根据组织id修改组织信息
     * @param id
     * @param requestVo
     * @param baseRequestVo
     */
    @Override
    public void putItemById(String id, OrganizationRequestBodyVO requestVo, BaseRequestVo baseRequestVo) {


                    Organization insertQueryVO = new Organization();
                    setUpdateOrgVO(id, requestVo, insertQueryVO, baseRequestVo);
                    organizationMapper.updateById(insertQueryVO);

    }

    @Override
    public PageBean<OrganizationDetails> findItems(OrganizationSelectQueryVO requestVo) {
        Page<OrganizationDetails> page = PageHelper.startPage(requestVo.getCurrentPage(), requestVo.getPageSize());
        //条件查询子组织信息
        List<OrganizationDetails> resultList = organizationMapper.findLists(requestVo);
        //分页包装
        PageBean<OrganizationDetails> pageData = new PageBean<>(requestVo.getCurrentPage(), requestVo.getPageSize(), (int)page.getTotal());
        pageData.setItems(resultList);
        return pageData;
    }
    /***
     * 根据组织id查询组织信息
     * @param id
     * @param baseRequestVo
     * @return
     */
    @Override
    public OrganizationDetails findItemById(String id, BaseRequestVo baseRequestVo) {
        return organizationMapper.findById(id);
    }

    /***
     * 新增组织实体赋值
     * @param requestVo
     * @param insertOrgVO
     * @param baseRequestVo
     */
    private void setInsertOrgVO(OrganizationRequestBodyVO requestVo,
                                Organization insertOrgVO, BaseRequestVo baseRequestVo) {

        insertOrgVO.setCreateOrgId(baseRequestVo.getRequestOrgId());
        insertOrgVO.setCreateUserId(baseRequestVo.getRequestUserId());
        insertOrgVO.setGmtCreate(new Date());
        insertOrgVO.setIsDeleted(SysConstant.FALSE);
        insertOrgVO.setSort(requestVo.getSort());
        insertOrgVO.setOrganizationName(requestVo.getOrganizationName());
        insertOrgVO.setOrganizationTelphone(requestVo.getOrganizationTelphone());
         insertOrgVO.setParentEmployerId(requestVo.getParentEmployerId());
        insertOrgVO.setId(UUIDGenerator.generate());
    }

    /**
     * 修改组织信息实体赋值
     *
     * @param requestVo
     * @param insertQueryVO
     * @param baseRequestVo
     */
    private void setUpdateOrgVO(String id, OrganizationRequestBodyVO requestVo, Organization insertQueryVO,
                                BaseRequestVo baseRequestVo) {

        insertQueryVO.setId(id);
        insertQueryVO.setOrganizationName(requestVo.getOrganizationName());

        insertQueryVO.setOrganizationTelphone(requestVo.getOrganizationTelphone());
        insertQueryVO.setUpdateUserId(baseRequestVo.getRequestUserId());

        insertQueryVO.setGmtModified(new Date());
        insertQueryVO.setSort(requestVo.getSort());


    }

}
