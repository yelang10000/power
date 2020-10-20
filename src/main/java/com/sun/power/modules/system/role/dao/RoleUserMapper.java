package com.sun.power.modules.system.role.dao;


import com.sun.power.modules.system.user.dto.AddUserVo;
import com.sun.power.modules.system.user.dto.UpdateUserVo;
import org.apache.ibatis.annotations.*;

/**
 *
 * @author : caoxin
 * @date : 2019/4/18
 */

@Mapper
public interface RoleUserMapper {

    /**
     * 添加角色时，给role_user添加信息
     * @param record
     * @return
     */
    @Insert({
            "insert into role_user (role_id,user_id,gmt_create,is_deleted,create_user_id,create_org_id)  ",
            "values (#{roleId,jdbcType=VARCHAR},#{id,jdbcType=VARCHAR}, now(), 0,#{createUserId,jdbcType=VARCHAR},#{createOrgId,jdbcType=VARCHAR})"
    })
    int insertRoleUser(AddUserVo record);

    /**
     * 修改角色时，修改role_user信息
     * @param record
     * @return
     */
    @Update({
            "update role_user",
            "set role_id = #{roleId,jdbcType=VARCHAR}, ",
            "gmt_modifiled = now(), ",
            "update_user_id = #{updateUserId} ",
            "where user_id = #{id,jdbcType=VARCHAR}"
    })
    int updateRoleUser(UpdateUserVo record);

    @Select({
            "select role_id from role_user where user_id = #{userId} and  is_deleted=0 "
    })
    String[] selectRoleByUserId(@Param("userId") String userId);
}


