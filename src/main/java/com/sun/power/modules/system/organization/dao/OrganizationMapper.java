package com.sun.power.modules.system.organization.dao;



import com.sun.power.core.aop.common.AopConstant;
import com.sun.power.core.common.entity.BaseDeleteQueryVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.modules.system.organization.dto.OrgDetails;
import com.sun.power.modules.system.organization.dto.OrganizationDetails;
import com.sun.power.modules.system.organization.dto.OrganizationRequestBodyVO;
import com.sun.power.modules.system.organization.dto.OrganizationSelectQueryVO;
import com.sun.power.modules.system.organization.entity.Organization;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrganizationMapper {

    /**
     * 根据组织名称查询组织是否存在
     * @param organizationRequestBodyVO
     * @return
     */
    @Select("SELECT COUNT(0) from organization where organization_name = #{organizationName} and  is_deleted=0")
    int findOrganizationByName(OrganizationRequestBodyVO organizationRequestBodyVO);
    @Delete({
        "delete from organization",
        "where id = #{id,jdbcType=VARCHAR}",
          "and sort = #{sort,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(@Param("id") String id, @Param("sort") Long sort);
    /***
     * 查询单位级别
     * @param id
     * @return
     */
    @Select(
            "SELECT dict_rank from organization where id = #{id}"
    )
    int findDictRank(String id);

    /***
     * 根据组织id查询组织信息
     * @param id
     * @return
     */
    @Select(
            "SELECT "
                    + " o.id, o1.organization_name  as parent_organization_name,  o.organization_name, o.parent_employer_id ,o.gmt_create "
                    + "from organization o left join organization o1 on  o1.id = o.parent_employer_id "
                    + "where o.id = #{id} "
    )
    OrganizationDetails findById(String id);

    /***
     * 根据父组织id查询子组织信息
     * @param id
     * @return
     */
    @Select( "SELECT o1.id,o1.organization_name from organization o left join organization o1 on  o.id = o1.parent_employer_id   where o1.is_deleted = 0 and  o.id = #{id} ORDER BY o1.id DESC LIMIT 1 ")
    Organization findByIdForChild(String id);

    /***
     * 根据组织id查询上级组织级别
     * @param id
     * @return
     */
    @Select(
            "SELECT "
                    + " dict_rank  "
                    + " FROM organization"
                    + " where id = #{id} "
    )
    Organization findParentOrgRank(String id);

    /**
     * 查询组织下是否存在用户
     * @param id
     * @return
     */
    @Select("select count(1) from user u  where u.is_deleted = 0 and u.organization_id = #{id} "

    )
    int userCount(String id);

    @Insert({
        "insert into organization (id,sort, organization_name, ",
        "parent_employer_id,  ",
        "dict_rank, gmt_create, ",
        "gmt_modified, is_deleted, ",
        "organization_telphone, create_user_id, ",
        "update_user_id, create_org_id)",

        "values (#{id,jdbcType=VARCHAR},#{sort,jdbcType=BIGINT}, #{organizationName,jdbcType=VARCHAR}, ",
        "#{parentEmployerId,jdbcType=VARCHAR}, ",
        "#{dictRank,jdbcType=INTEGER}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModified,jdbcType=TIMESTAMP}, #{isDeleted,jdbcType=TINYINT}, ",
        "#{organizationTelphone,jdbcType=VARCHAR}, #{createUserId,jdbcType=VARCHAR}, ",
        "#{updateUserId,jdbcType=VARCHAR}, #{createOrgId,jdbcType=VARCHAR}) "
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=String.class)
    int insert(Organization record);
    /***
     * 查询组织下是否存在子组织
     * @param id
     * @return
     */
    @Select(
            "SELECT "
                    + "count(0) "
                    + "from organization o  "
                    + "where o.parent_employer_id =  #{id} "
    )
    int queryIsSubunit(String id);
    /***
     * 条件查询组织信息
     * @param selectRequestQueryVO
     * @return
     */
    @Select(
            "<script>"
                    + "SELECT "
                    + "id, organization_name , organization_telphone,sort,dict_rank,gmt_create "
                    + "from organization  "
                    + "<where>"
                    + "<if test='organizationName != null'>     AND organization_name like concat('%', #{organizationName}, '%') " + AopConstant.ESCAPE_SQL + "</if> "
                    + " AND is_deleted=0 "
                    + "and parent_employer_id= #{parentEmployerId,jdbcType=VARCHAR}"
                    + "</where>"
                    + " ORDER BY gmt_create DESC"
                    + "</script>")
    List<OrganizationDetails> findOrgById(OrganizationSelectQueryVO selectRequestQueryVO);

    /***
     * 条件查询组织信息
     * @param selectRequestQueryVO
     * @return
     */
    @Select(
            "<script>"
                    + "SELECT "
                    + "o.id, o1.organization_name as parent_organization_name, o.organization_name, o.organization_telphone,  o.parent_employer_id,o.sort,o.dict_rank "
                    + "from organization o left join organization o1 on  o1.id = o.parent_employer_id "
                    + "<where>"
                    + "<if test='organizationName != null'>     AND o.organization_name like concat('%', #{organizationName}, '%') " + AopConstant.ESCAPE_SQL + "</if> "
                    + "<if test='parentEmployerId != null'>     AND o.parent_employer_id = #{parentEmployerId} </if> "
                    + "<if test='orgIdForDataSelect != null'>     AND  o.id like concat(#{orgIdForDataSelect}, '%')</if> "
                    + " AND o1.is_deleted=0 "
                    + " AND o.is_deleted=0 "
                    + "</where>"
                    + " ORDER BY o.gmt_create DESC"
                    + "</script>")
    List<OrganizationDetails> findLists(OrganizationSelectQueryVO selectRequestQueryVO);

    /***
     * 查询子单位信息
     * @param id
     * @return
     */
    @Select(
            "call allChildOrganization(#{id}); "
    )
    @Options(statementType= StatementType.CALLABLE)
    List<OrgDetails> getListsAll(String id);

    @Select({
        "select",
        "id, sort, organization_name, parent_employer_id, province, city, district, is_lgb_ministry, ",
        "dict_organization_type, dict_rank, gmt_create, gmt_modified, is_deleted, organization_telphone, ",
        "create_user_id, update_user_id, create_org_id, is_media",
        "from organization",
        "where id = #{id,jdbcType=VARCHAR}",
          "and sort = #{sort,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="sort", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="organization_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="parent_employer_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="province", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="city", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="district", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_lgb_ministry", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="dict_organization_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="dict_rank", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="gmt_create", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="gmt_modified", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="is_deleted", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="organization_telphone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="update_user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_org_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="is_media", javaType=Byte.class, jdbcType=JdbcType.TINYINT)
    })
    Organization selectByPrimaryKey(@Param("id") String id, @Param("sort") Long sort);

    /**
     * 逻辑删除组织信息
     * @param baseDeleteQueryVO
     */
    @Delete({
            "<script>",
            "update organization",
            "set is_deleted = 1, " ,
            "gmt_modified= now()," ,
            "update_user_id= #{updateUserId} " ,
            "<where>",
            "id in ",
            "<foreach  collection='ids' item='item' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</where>",
            "</script>"
    })
    int deleteByIds(BaseDeleteQueryVO baseDeleteQueryVO);

    @Update({
        "update organization",
        "set organization_name = #{organizationName,jdbcType=VARCHAR},",
          "parent_employer_id = #{parentEmployerId,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "district = #{district,jdbcType=VARCHAR},",
          "is_lgb_ministry = #{isLgbMinistry,jdbcType=TINYINT},",
          "dict_organization_type = #{dictOrganizationType,jdbcType=VARCHAR},",
          "dict_rank = #{dictRank,jdbcType=INTEGER},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "organization_telphone = #{organizationTelphone,jdbcType=VARCHAR},",
          "create_user_id = #{createUserId,jdbcType=VARCHAR},",
          "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
          "create_org_id = #{createOrgId,jdbcType=VARCHAR},",
          "is_media = #{isMedia,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=VARCHAR}",
          "and sort = #{sort,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Organization record);

    /**
     * 根据组织id修改组织信息
     * @param insertQueryVO
     */
    @Update({

            "update organization ",
            "set ",
            " update_user_id = #{updateUserId} ,",
            " gmt_modified = #{gmtModified}, ",
            " sort = #{sort}, ",
            " organization_telphone = #{organizationTelphone}, ",
            " organization_name = #{organizationName} ",
            "where id = #{id}"
    })
    void updateById(Organization insertQueryVO);
}