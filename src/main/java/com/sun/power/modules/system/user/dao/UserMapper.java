package com.sun.power.modules.system.user.dao;


import com.sun.power.core.aop.common.AopConstant;
import com.sun.power.core.common.entity.BaseDeleteQueryVO;

import com.sun.power.modules.system.user.dto.*;
import com.sun.power.modules.system.user.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 逻辑批量删除人员
     * @param baseDeleteQueryVO
     * @return
     */
    @Update({
            "<script>"
                    + "update user "
                    + "set is_deleted = 1, gmt_modified=#{gmtModified}, update_user_id=#{updateUserId} "
                    + "<where> id in "
                    + "<foreach collection='ids' item='id' open='(' separator=',' close=')'> "
                    + "  #{id} "
                    + "</foreach> "
                    + "</where>"
                    + "</script>"
    })
    int deleteUserByIds(BaseDeleteQueryVO baseDeleteQueryVO);

    /**
     * 生分证的唯一性校验
     * list
     * @return
     */

    @Select({
            "select id_card from user where is_deleted = 0"
    })
    List<String> idCardList();
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Update({
            "update user",
            "set ",

            "time_of_login = #{dateOfLogin,jdbcType=DATE}",

            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateUserLogin(UserLogin record);

    @Insert({
        "insert into user (id,organization_id, user_name, ",
        "password, real_name, ",
        "id_card, dict_sex, ",
        "date_of_birth, ",
        " phone_number, ",
        "create_user_id,  ",
        "gmt_create, ",
        "is_deleted, create_org_id, ",
        "party_time, time_of_login,dict_nation,dict_political_status,dict_degree)",
        "values (#{id,jdbcType=VARCHAR},#{organizationId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, ",
        "#{idCard,jdbcType=VARCHAR}, #{dictSex,jdbcType=VARCHAR}, ",
        "#{dateOfBirth,jdbcType=DATE}, #{phoneNumber,jdbcType=VARCHAR}, ",
        "#{createUserId,jdbcType=VARCHAR},  ",
        "now(), ",
        "0, #{createOrgId,jdbcType=VARCHAR}, ",
        "#{partyTime,jdbcType=VARCHAR}, #{timeOfLogin,jdbcType=TIMESTAMP},#{dictNation,jdbcType=VARCHAR},#{dictPoliticalStatus,jdbcType=VARCHAR},#{dictDegree,jdbcType=VARCHAR})"
    })
    int insert(AddUserVo record);


    /**
     * di查工作人员
     * @param id
     * @return
     */
    @Select({
        "select",
        "u.id, u.organization_id, u.user_name, u.password, u.real_name, u.id_card, u.dict_sex, u.date_of_birth, ",
        "u.phone_number, u.create_user_id, ",
        "u.update_user_id, u.gmt_create,u.gmt_modified, u.create_org_id, u.party_time, ",
        "u.time_of_login ,r.id as roleId,r.role_name",
        "from user u",
            "LEFT JOIN  organization o on u.organization_id = o.id",
            "LEFT JOIN  role_user roleU  on u.id = roleU.user_id",
            "LEFT JOIN  role r  on roleU.role_id = r.id",
            "where u.id = #{id,jdbcType=VARCHAR} and u.is_deleted = 0 "
    })
    User selectByPrimaryKey(String id);

    @Select({
            "select",
            "id, organization_id, user_name, password, real_name, id_card, dict_sex, date_of_birth, ",
            "phone_number,  create_user_id, ",
            "update_user_id, gmt_create, gmt_modified, create_org_id, party_time, ",
            "time_of_login",
            "from user",
            "where user_name = #{username,jdbcType=VARCHAR} and  is_deleted=0 "
    })
    @ConstructorArgs({
            @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
            @Arg(column="organization_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="user_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="real_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="id_card", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="dict_sex", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="date_of_birth", javaType=Date.class, jdbcType=JdbcType.DATE),
            @Arg(column="phone_number", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="create_user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="update_user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="gmt_create", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="gmt_modified", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="create_org_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="party_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="time_of_login", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    User findByUserName(String username);

    @Update({
        "update user",
        "set organization_id = #{organizationId,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "id_card = #{idCard,jdbcType=VARCHAR},",
          "dict_sex = #{dictSex,jdbcType=VARCHAR},",
          "date_of_birth = #{dateOfBirth,jdbcType=DATE},",
          "phone_number = #{phoneNumber,jdbcType=VARCHAR},",
          "dict_health_status = #{dictHealthStatus,jdbcType=VARCHAR},",
          "create_user_id = #{createUserId,jdbcType=VARCHAR},",
          "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "create_org_id = #{createOrgId,jdbcType=VARCHAR},",
          "party_time = #{partyTime,jdbcType=VARCHAR},",
          "time_of_login = #{timeOfLogin,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);


    /**
     * 编辑工作人员
     * @param requestVo
     * @return
     */
    @Update({
            "update user",
            "set ",
            "id_card = #{idCard,jdbcType=VARCHAR},",
            "dict_sex = #{dictSex,jdbcType=VARCHAR},",
            "organization_id = #{organizationId,jdbcType=VARCHAR},",
            "user_name = #{phoneNumber,jdbcType=VARCHAR},",
            "real_name = #{realName,jdbcType=VARCHAR},",
            "date_of_birth = #{dateOfBirth},",
            "phone_number = #{phoneNumber,jdbcType=VARCHAR},",
            "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
            "create_org_id = #{organizationId,jdbcType=VARCHAR},",
            "gmt_modified = now() ",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateUser(UpdateUserVo requestVo);

    /**
     * 编辑
     * @param requestVo
     * @return
     */
    @Update({
            "update role_user",
            "set role_id = #{roleId,jdbcType=VARCHAR},",
            "update_user_id = #{updateUserId,jdbcType=VARCHAR},",

            "gmt_modified = now() ",
            "where user_id = #{id,jdbcType=VARCHAR}"
    })
    int updateRole(UpdateUserVo requestVo);

    /**
     * 查询列表  模糊查询
     * @param userTakeVo
     * @return
     */
//    @Select({
//            "<script>" +
//                    "SELECT u.id,u.id_card,u.user_name,u.organization_id," +
//                    "real_name,rel.id as role_id,rel.role_name,u.phone_number,u.dict_sex," +
//                    "u.password,o.organization_name," +
//                    "u.date_of_birth from user u " +
//                    " LEFT JOIN organization o"+
//                    "  on u.organization_id = o.id"+
//                    " LEFT JOIN role_user role"+
//                    " on u.id = role.user_id "+
//                    " LEFT JOIN role rel"+
//                    " on role.role_id = rel.id",
//                    "<where>"+
//                    "<if test='userName != null'> AND u.user_name like concat('%',#{userName},'%')"+ AopConstant.ESCAPE_SQL+"</if>"+
//                    "<if test='realName != null'> AND u.real_name like concat('%',#{realName},'%')"+AopConstant.ESCAPE_SQL+"</if>"+
//                    " AND u.is_deleted = 0 "+
//                    "and role.is_deleted = 0 "+
//                    "and rel.is_deleted = 0 "+
//                    "and user_name != 'admin' "+
//                    "${dataAuthSql} ",
//            "</where>"+
//                    "ORDER BY u.gmt_create DESC,u.id DESC ",
//            "</script>"
//    })
    @Select({
            "<script>" +
                    "SELECT u.id, u.id_card,u.user_name,u.organization_id,real_name,rel.id as role_id,rel.role_name,u.phone_number,u.dict_sex,u.gmt_create ,u.date_of_birth, " +
                    " u.password,o.organization_name from user u " +
                    "LEFT JOIN organization o on u.organization_id = o.id "+
                    "LEFT JOIN role_user roleU on u.id = roleU.user_id "+
                    "LEFT JOIN role rel on roleU.role_id = rel.id "+
                    "<where>"+
                    "<if test='userName != null'> AND u.user_name like concat('%',#{userName},'%')"+ AopConstant.ESCAPE_SQL+"</if>"+
                    "<if test='realName != null'> AND u.real_name like concat('%',#{realName},'%')"+AopConstant.ESCAPE_SQL+"</if>"+
                    " AND u.is_deleted = 0 "+
                    "and roleU.is_deleted = 0 "+
                    "and rel.is_deleted = 0 "+
                    "and user_name != 'admin' "+
                    "${dataAuthSql} ",
            "</where>"+
                    "ORDER BY u.gmt_create DESC,u.id DESC ",

            "</script>"
    })
    @ConstructorArgs({
            @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
            @Arg(column="role_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="role_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="organization_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="organization_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),

            @Arg(column="user_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="real_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="id_card", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="dict_sex", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="phone_number", javaType=String.class, jdbcType=JdbcType.VARCHAR),
            @Arg(column="gmt_create", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
            @Arg(column="date_of_birth", javaType=Date.class, jdbcType=JdbcType.DATE)

    })
    List<User> selectAllUser(QueryUserVo userTakeVo);

    /**
     * 电话号码的唯一性校验
     * list
     * @return
     */

    @Select({
            "select phone_number from user where is_deleted = 0 and phone_number = #{phoneNumber}"
    })
    List<String> phoneNumberList(String phoneNumber);

    /**
     *重置密码
     * @param id
     *  @param password
     */
    @Update({
            "update user set password = #{password} " ,
            "where id = #{id} and is_deleted = 0"
    })
    void resetPassword(@Param("id")String  id,@Param("password")String password);

    /**
     * 修改密码
     * @param updatePasswordVo
     * @return
     */
    @Update({
            "update user set password = #{newPassword} ," ,
            "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
            "gmt_modified = now() ",
            "where id = #{id} and is_deleted = 0"
    })
    void checkoutPassword(UpdatePasswordVo updatePasswordVo);
}