package com.sun.power.modules.system.role.dao;


import com.sun.power.modules.system.role.entity.RoleRule;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleRuleMapper {
    @Insert({
        "insert into role_rule (role_id, ruler_id, ",
        "gmt_create, gmt_modified, ",
        "is_deleted, create_user_id, ",
        "update_user_id, create_org_id)",
        "values (#{roleId,jdbcType=VARCHAR}, #{rulerId,jdbcType=VARCHAR}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP}, ",
        "#{isDeleted,jdbcType=TINYINT}, #{createUserId,jdbcType=VARCHAR}, ",
        "#{updateUserId,jdbcType=VARCHAR}, #{createOrgId,jdbcType=VARCHAR})"
    })
    int insert(RoleRule record);


}