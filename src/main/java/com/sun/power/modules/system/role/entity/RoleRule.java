package com.sun.power.modules.system.role.entity;

import java.util.Date;

public class RoleRule {
    private String roleId;

    private String rulerId;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDeleted;

    private String createUserId;

    private String updateUserId;

    private String createOrgId;

    public RoleRule(String roleId, String rulerId, Date gmtCreate, Date gmtModified, Byte isDeleted, String createUserId, String updateUserId, String createOrgId) {
        this.roleId = roleId;
        this.rulerId = rulerId;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDeleted = isDeleted;
        this.createUserId = createUserId;
        this.updateUserId = updateUserId;
        this.createOrgId = createOrgId;
    }

    public RoleRule() {
        super();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRulerId() {
        return rulerId;
    }

    public void setRulerId(String rulerId) {
        this.rulerId = rulerId == null ? null : rulerId.trim();
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

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
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