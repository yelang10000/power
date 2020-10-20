package com.sun.power.modules.system.organization.service;

import com.sun.power.core.common.entity.BaseDeleteRequestBodyVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;
import com.sun.power.core.common.service.Impl.BaseService;
import com.sun.power.modules.system.organization.dto.*;

import java.util.List;

/**
 * @Author 贾涛
 * @Date 2020/10/17 10:02
 * @Version 1.0
 */
public interface OrganizationService extends BaseService<OrganizationRequestBodyVO, BaseDeleteRequestBodyVO,OrganizationRequestBodyVO, OrganizationSelectQueryVO, OrganizationDetails> {
    /***
     * 根据组织id查询所有子组织信息
     * @param id
     * @param baseRequestVo
     * @return
     */
    public List<OrganizationDetails> findChildByOrgId (String id, BaseRequestVo baseRequestVo);

    /***
     * 根据条件查询组织信息的子组织信息
     * @param requestVo
     * @return
     */
    public PageBean<OrganizationDetails> findItemsAll (OrganizationSelectQueryVO requestVo);

    /***
     * 根据条件查询组织信息的子组织信息
     * @param requestVo
     * @return
     */
    public PageBean<OrganizationDetails> findItemsAll1 (OrganizationSelectQueryVO requestVo);

    /***
     * 根据组织id查询直属子组织信息
     * @param id
     * @param baseRequestVo
     * @return
     */
    public List<OrganizationDetails> findDirectlyChildByOrgId (String id, BaseRequestVo baseRequestVo);

    /***
     * 根据条件查询组织信息-不分页
     * @param requestVo
     * @return
     */
    public List<OrganizationDetails> getListAll (OrgSelectVO requestVo);

    /***
     * 查询所有子单位
     * @param orgId
     * @return
     */
    public List<OrgDetails> getListsAll (String orgId);

    /***
     * 根据条件查询组织信息的下级子组织信息
     * @param requestVo
     * @return
     */
    public PageBean<OrganizationDetails> findOrgById (OrganizationSelectQueryVO requestVo);

}
