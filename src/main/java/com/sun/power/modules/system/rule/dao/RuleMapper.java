package com.sun.power.modules.system.rule.dao;



import com.sun.power.core.common.entity.BaseDeleteQueryVO;
import com.sun.power.modules.system.rule.dto.AddRuleVo;
import com.sun.power.modules.system.rule.dto.QueryAllRuleVo;
import com.sun.power.modules.system.rule.dto.ResultRuleVo;
import com.sun.power.modules.system.rule.dto.UpdateRuleVo;
import com.sun.power.modules.system.rule.entity.Rule;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

@Mapper
public interface RuleMapper {
    /**
     * 根据权限名称查询权限是否存在
     * @param rule
     * @return
     */
    @Select("SELECT COUNT(0) from rule where rule_name = #{ruleName} and  is_deleted=0")
    int findRuleByName(AddRuleVo rule);
    @Delete({
        "delete from rule",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);
    /***
     * 根据父权限id查询子权限信息
     * @param id
     * @return
     */
    @Select( "SELECT o1.id,o1.rule_name,o1.url,o1.parent_id from rule o left join rule o1 on  o.id = o1.parent_id   where o1.is_deleted = 0 and  o1.parent_id = #{id} ORDER BY o1.id DESC LIMIT 1 ")
    ResultRuleVo findByIdForChild(String id);

    /***
     * 新增权限
     * @param record
     * @return
     */
    @Insert({
            "insert into rule (id,rule_name, ",
            "parent_id, url, ",
            "remark,  ",
            "gmt_create, is_deleted,  ",
            "create_user_id, ",
            "create_org_id) ",
            "values (#{id,jdbcType=VARCHAR},#{ruleName,jdbcType=BIGINT}, #{parentRuleId,jdbcType=VARCHAR}, ",
            "#{url,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
            "now(), 0, ",
            "#{createUserId,jdbcType=VARCHAR}, ",
            "#{createOrgId,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=String.class)
    int insert(AddRuleVo record);



    @Select({
        "select",
        "id, rule_name, url, remark, parent_id, gmt_create, gmt_modified, is_deleted, ",
        "create_user_id, update_user_id, create_org_id",
        "from rule",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="rule_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="url", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="parent_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gmt_create", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="gmt_modified", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="is_deleted", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="create_user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="update_user_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_org_id", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Rule selectByPrimaryKey(String id);



    @Update({
        "update rule",
        "set rule_name = #{ruleName,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "create_user_id = #{createUserId,jdbcType=VARCHAR},",
          "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
          "create_org_id = #{createOrgId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Rule record);

    /***
     * 查询所有按parentId倒序排序取一条
     * @param
     * @return rule
     */
    @Select({
            "select id,rule_name,parent_id,url,component,hideIn_menu,name,path from rule where is_deleted = 0 order by  parent_id desc limit 1"
    })
    Rule selectLastRule();

    /**
     * 添加一级权限 查询最大一级权限的id
     * @return Rule
     */
    @Select({
            "select id,rule_name,parent_id,url,component,hideIn_menu,name,path from rule where parent_id = '00' and is_deleted = 0 order by id desc limit 1"
    })
    Rule selectStairId();

    /**
     * 查询所有一级权限
     * @return Rule
     */
    @Select({
            "select id,rule_name,remark,parent_id,url  from rule where parent_id = '00' and is_deleted = 0 order by id"
    })
    List<ResultRuleVo> selectAllStair();

    /**
     * 根据一级权限查询所有子权限
     * @param parentId
     * @return Rule
     */
    @Select({
            "SELECT "
                    + "id, rule_name,parent_id ,remark,url  "
                    + "from rule  "
                    + "where id like concat(#{parentId},'%') and is_deleted = 0"
    })
    List<ResultRuleVo> selectChildForParentId(@Param("parentId") String parentId);

    /**
     * 根据一级权限查询二级权限
     * @param parentId
     * @return Rule
     */
    @Select({
            "SELECT "
                    + "id, rule_name,parent_id ,url  "
                    + "from rule  "
                    + "where parent_id = #{parentId} and is_deleted = 0"
    })
    List<QueryAllRuleVo> selectSonForParentId(@Param("parentId") String parentId);

    /**
     * 根据一级权限查询所有子权限倒叙排序只取一条
     * @param parentId
     * @return Rule
     */
    @Select({
            "select  id,rule_name,parent_id,url from rule where parent_id = #{parentId} and is_deleted = 0 order by id desc limit 1"
    })
    Rule selectChildForParentIdGetOne(@Param("parentId") String parentId);

    /**
     * 修二级权限
     * @param rule
     * @return int
     */
    @Update({
            "update rule ",
            "set parent_id = #{parentRuleId,jdbcType=VARCHAR},",
            "rule_name = #{ruleName,jdbcType=VARCHAR},",
            "url = #{url,jdbcType=VARCHAR},",
            "remark = #{remark,jdbcType=VARCHAR},",
            "gmt_modified = now(),",
            "id = #{url,jdbcType=VARCHAR},",
            "update_user_id = #{updateUserId,jdbcType=VARCHAR} where id = #{id}"
    })
    int updateSecondRule(UpdateRuleVo rule);

    /**
     * 修改一级权限
     * @param rule
     * @return int
     */
    @Update({
            "update rule ",
            "set rule_name = #{ruleName,jdbcType=VARCHAR},",
            "remark = #{remark,jdbcType=VARCHAR},",
            "gmt_modified = now(),",
            "update_user_id = #{updateUserId,jdbcType=VARCHAR} where id = #{id}"
    })
    int updateFirstRule(UpdateRuleVo rule);


    /**
     * 批量逻辑删除权限
     * @param baseDeleteQueryVO
     * @return int
     */
    @Delete({
            "<script> ",
            "update  rule set is_deleted = 1, gmt_modified=#{gmtModified}, update_user_id=#{updateUserId} ",
            "<where> id in ",
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'> ",
            "  #{id} ",
            "</foreach> ",
            "</where>",
            "</script>"
    })
    int deleteByIds(BaseDeleteQueryVO baseDeleteQueryVO);

    /**
     * 根据id删除权限
     * @param id
     * @return int
     */
    @Update({
            "update rule ",
            "set is_deleted = 1, gmt_modified=now(), update_user_id=#{updateUserId} ",
            "where id = #{id}"
    })
    int deleteByid(@Param("id") String id,@Param("updateUserId") String updateUserId);

    /**
     * 通过权限id查询parent_id
     * @param id
     * @return int
     */
    @Select({
            "select parent_id from rule where id = #{id} and is_deleted = 0"
    })
    String selectParentId(@Param("id") String id);

    @Select({
            "select id,parent_id,rule_name,url from rule where url = #{url} and is_deleted = 0"
    })
    ResultRuleVo selectRuleByUrl(@Param("url") String url);
    /**
     * 通过权限id查询权限所有信息
     * @param id
     * @return rule
     */
    @Select({
            "select  id,parent_id,rule_name,url,",
            "remark,gmt_create,gmt_modified,create_user_id,update_user_id,",
            "create_org_id from rule where id = #{id} and is_deleted = 0"
    })
    ResultRuleVo findItemById(@Param("id") String id);

    /**
     * 通过权限id查询一级权限所有信息
     * @param url
     * @return rule
     */
    @Select({
            "select  id,parent_id,rule_name,url ,",
            "remark,gmt_create,gmt_modified,create_user_id,update_user_id,",
            "create_org_id from rule where url = #{url} and is_deleted = 0"
    })
    ResultRuleVo findItemByUrl(@Param("url") String url);

    /**
     * 通过权限id查询二级权限所有信息
     * @param parentId
     * @return rule
     */
    @Select({
            "select  id,parent_id,rule_name,url,",
            "remark,gmt_create,gmt_modified,create_user_id,update_user_id,",
            "create_org_id from rule where parent_id = #{parentId} and is_deleted = 0"
    })
    List<ResultRuleVo> findItemsByUrl(@Param("parentId") String parentId);
}