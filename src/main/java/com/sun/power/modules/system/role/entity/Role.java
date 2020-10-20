package com.sun.power.modules.system.role.entity;

import java.util.Date;

public class Role {
    private String id;

    private String roleName;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDeleted;

    private String createUserId;

    private String updateUserId;

    private String createOrgId;

    private String path;

    private String name;

    private String component;

    private String hideinMenu;

    private Byte isAdmin;

    public Role(String id, String roleName, String remark, Date gmtCreate, Date gmtModified, Byte isDeleted, String createUserId, String updateUserId, String createOrgId, String path, String name, String component, String hideinMenu, Byte isAdmin) {
        this.id = id;
        this.roleName = roleName;
        this.remark = remark;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDeleted = isDeleted;
        this.createUserId = createUserId;
        this.updateUserId = updateUserId;
        this.createOrgId = createOrgId;
        this.path = path;
        this.name = name;
        this.component = component;
        this.hideinMenu = hideinMenu;
        this.isAdmin = isAdmin;
    }

    public Role() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    public String getHideinMenu() {
        return hideinMenu;
    }

    public void setHideinMenu(String hideinMenu) {
        this.hideinMenu = hideinMenu == null ? null : hideinMenu.trim();
    }

    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }
}