package com.sun.power.modules.system.organization.entity;

import java.util.Date;

public class Organization {
    private String id;

    private Long sort;

    private String organizationName;

    private String parentEmployerId;

    private String province;

    private String city;

    private String district;

    private Byte isLgbMinistry;


    private Integer dictRank;

    private Date gmtCreate;

    private Date gmtModified;

    private int isDeleted;

    private String organizationTelphone;

    private String createUserId;

    private String updateUserId;

    private String createOrgId;



    public Organization(String id, Long sort, String organizationName, String parentEmployerId, String province, String city, String district, Byte isLgbMinistry,  Integer dictRank, Date gmtCreate, Date gmtModified, int isDeleted, String organizationTelphone, String createUserId, String updateUserId, String createOrgId) {
        this.id = id;
        this.sort = sort;
        this.organizationName = organizationName;
        this.parentEmployerId = parentEmployerId;
        this.province = province;
        this.city = city;
        this.district = district;
        this.isLgbMinistry = isLgbMinistry;

        this.dictRank = dictRank;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDeleted = isDeleted;
        this.organizationTelphone = organizationTelphone;
        this.createUserId = createUserId;
        this.updateUserId = updateUserId;
        this.createOrgId = createOrgId;

    }

    public Organization() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName == null ? null : organizationName.trim();
    }

    public String getParentEmployerId() {
        return parentEmployerId;
    }

    public void setParentEmployerId(String parentEmployerId) {
        this.parentEmployerId = parentEmployerId == null ? null : parentEmployerId.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public Byte getIsLgbMinistry() {
        return isLgbMinistry;
    }

    public void setIsLgbMinistry(Byte isLgbMinistry) {
        this.isLgbMinistry = isLgbMinistry;
    }

    public Integer getDictRank() {
        return dictRank;
    }

    public void setDictRank(Integer dictRank) {
        this.dictRank = dictRank;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getOrganizationTelphone() {
        return organizationTelphone;
    }

    public void setOrganizationTelphone(String organizationTelphone) {
        this.organizationTelphone = organizationTelphone == null ? null : organizationTelphone.trim();
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public String getCreateOrgId() {
        return createOrgId;
    }

    public void setCreateOrgId(String createOrgId) {
        this.createOrgId = createOrgId == null ? null : createOrgId.trim();
    }

}