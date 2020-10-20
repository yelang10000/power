package com.sun.power.modules.system.role.dao;


import com.sun.power.core.aop.common.AopConstant;
import com.sun.power.core.common.entity.BaseDeleteQueryVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.modules.system.role.dto.*;
import com.sun.power.modules.system.role.entity.Role;
import com.sun.power.modules.system.rule.dto.ResultRuleVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

@Mapper
public interface RoleMapper {
    /**
     *查询所有
     * @param roleTakeVo
     * @return
     */
    @Select({
            "<script>" +
                    "SELECT id,role_name,remark,is_admin from role  " +
                    "<where>"+
                    "<if test='roleName != null'> AND role_name like concat('%',#{roleName},'%')"+ AopConstant.ESCAPE_SQL+"</if>"+
                    " AND is_deleted = 0 and id != '402882866a4dab69016a4dab69dc' "+
                    "${dataAuthSql} ",
            "</where>"+
                    "ORDER BY gmt_create DESC",
            "</script>"
    })
    List<Role> selectAllRole(QueryRoleVo roleTakeVo);

    /**
     * 角色名称校验  roleNameOnlyCheckout
     * @return
     */
    @Select({
            "select role_name from role where is_deleted = 0 and role_name = #{roleName} and create_org_id = #{baseRequestVo.requestOrgId}"
    })
    String roleNameList(@Param("roleName") String roleName,@Param("baseRequestVo") BaseRequestVo baseRequestVo);
    @Insert({
            "<script>"
                    + "INSERT INTO  role_rule "
                    + "(role_id , ruler_id, gmt_create,is_deleted,create_user_id,create_org_id) "
                    +" VALUES "
                    + "<foreach collection='ids' item='ruleID'  separator=',' > "
                    + " ( #{roleId}, #{ruleID},now(), 0,#{createUserId} ,#{createOrgId}  )"
                    + "</foreach> "
                    + "</script>"
    })
    int roleAddRule(RoleAddRuleVo roleRule);


    /**
     * 角色删除权限
     * @param roleRule
     * @return
     */
    @Update({
            "<script>"
                    + "update role_rule "
                    + "set gmt_modified = now(), "
                    + "is_deleted = 1,update_user_id= #{updateUserId,jdbcType=VARCHAR} "
                    + "<where> role_id = #{roleId} and ruler_id in "
                    + "<foreach collection='ids' item='ruleID'  open='(' separator=',' close=')'> "
                    + "  #{ruleID} "
                    + "</foreach> "
                    + "</where>"
                    + "</script>"
    })
    int roleDeleteRule(RoleDeleteRuleVo roleRule);
    /**
     * 角色下的用户id
     * @param roleId
     * @return
     */
    @Select({
            "select user_id from role_user where role_id = #{roleId} and create_org_id = #{orgId}"
    })
    List<String> roleHasUser(@Param("roleId") String roleId,@Param("orgId") String orgId);
    /**
     * 获取菜单id
     * @param roleId
     * @return
     */
    @Select({
            "select ruler_id  from role_rule where role_id = #{roleId} and is_deleted=0"
    })
    List<String> selectRuleByRoleId(@Param("roleId") String roleId);
    @Select({
            "<script>"
                    + "SELECT id,rule_name,url,remark,parent_id FROM rule "
                    + "<where> id in "
                    + "<foreach collection='ruleId' item='ruleID'  open='(' separator=',' close=')'> "
                    + "  #{ruleID} "
                    + "</foreach> "
                    + "</where>"
                    + "</script>"
    })
    List<ResultRuleVo> selectRuleByrole(@Param("ruleId") List<String> ruleId);

    @Select({
            "<script>"
                    + "SELECT id,rule_name,url,remark,parent_id FROM rule "
                    + "<where> id in "
                    + "<foreach collection='ruleId' item='ruleID'  open='(' separator=',' close=')'> "
                    + "  #{ruleID} "
                    + "</foreach> "
                    + "</where>"
                    +" and parent_id = 00"
                    + "</script>"
    })
    List<ResultRuleVo> selectParentRuleByrole(@Param("ruleId") List<String> ruleId);
    @Insert({
            "<script>"
                    + "INSERT INTO  role_rule "
                    + "(role_id , ruler_id, gmt_create,is_deleted,create_user_id,create_org_id) "
                    +" VALUES "
                    + "<foreach collection='ids' item='ruleID'  separator=',' > "
                    + " ( #{roleId}, #{ruleID},now(), 0,#{createUserId} ,#{createOrgId}  )"
                    + "</foreach> "
                    + "</script>"
    })
    int roleAddUpRule(RoleDeleteRuleVo roleRule);

    /**
     * 角色删除权限
     * @param roleRule
     * @return
     */
    @Update({

            "delete from role_rule  where role_id = #{roleId}"

    })
    int roleDeleteUpRule(RoleDeleteRuleVo roleRule);

    @Delete({
        "delete from role",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into role (id,role_name, remark, ",
        "gmt_create,  ",
        "is_deleted, create_user_id, ",
        " create_org_id, ",
        " is_admin)",
        "values (#{id,jdbcType=VARCHAR},#{roleName,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "now(), ",
        "0, #{createUserId,jdbcType=VARCHAR}, ",
        " #{createOrgId,jdbcType=VARCHAR}, ",
        "#{isAdmin,jdbcType=TINYINT})"
    })
    int insertRole(AddRoleVo record);

    /**
     * 逻辑批量删除角色
     * @param baseDeleteQueryVO
     * @return
     */
    @Update({
            "<script>"
                    + "update role "
                    + "set is_deleted = 1, gmt_modified=#{gmtModified}, update_user_id=#{updateUserId} "
                    + "<where> id in "
                    + "<foreach collection='ids' item='id' open='(' separator=',' close=')'> "
                    + "  #{id} "
                    + "</foreach> "
                    + "</where>"
                    + "</script>"
    })
    int deleteRoleByIds(BaseDeleteQueryVO baseDeleteQueryVO);
    /**
     * 根据id查询角色信息
     * @param id
     * @return
     */
    @Select({
            "select",
            "id, role_name, remark,is_admin, gmt_create, gmt_modified, is_deleted, create_user_id, ",
            "update_user_id, create_org_id",
            "from role",
            "where id = #{id,jdbcType=VARCHAR} and  is_deleted=0 "
    })
    Role selectById(String id);
    /**
     * 编辑角色
     * @param role
     * @return
     */
    @Update({
            "update role",
            "set role_name = #{roleName,jdbcType=VARCHAR},",
            "remark = #{remark,jdbcType=VARCHAR},",
            "is_admin = #{isAdmin},",
            "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
            "gmt_modified = now() ",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateUser(UpdateRoleVo role);

    @Select({
        "select",
        "id, role_name, remark, gmt_create, gmt_modified, is_deleted, create_user_id, ",
        "update_user_id, create_org_id, path, name, component, hideIn_menu, is_admin",
        "from role",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="role_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gmt_create", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="gmt_modified", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="is_deleted", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="create_user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="update_user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_org_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="path", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="component", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="hideIn_menu", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_admin", javaType=Byte.class, jdbcType=JdbcType.TINYINT)
    })
    Role selectByPrimaryKey(String id);


    @Update({
        "update role",
        "set role_name = #{roleName,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "create_user_id = #{createUserId,jdbcType=VARCHAR},",
          "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
          "create_org_id = #{createOrgId,jdbcType=VARCHAR},",
          "path = #{path,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "component = #{component,jdbcType=VARCHAR},",
          "hideIn_menu = #{hideinMenu,jdbcType=VARCHAR},",
          "is_admin = #{isAdmin,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Role record);

    /**
     * 根据用户id 查询 是否为用户管理员
     * 0-否 1-是
     * @return
     */
    @Select("SELECT IFNULL(role.is_admin,0) FROM `role` LEFT JOIN role_user on role.id = role_user.role_id WHERE role_user.is_deleted != 1 AND role.is_deleted != 1 AND role_user.user_id = #{userId}")
    Integer selectIsAdminByUserId(@Param("userId") String userId);
}