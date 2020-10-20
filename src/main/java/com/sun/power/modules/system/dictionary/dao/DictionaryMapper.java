package com.sun.power.modules.system.dictionary.dao;


import com.sun.power.core.aop.common.AopConstant;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.modules.system.dictionary.model.Dictionary;
import com.sun.power.modules.system.dictionary.vo.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
public interface DictionaryMapper {
    @Delete({
        "delete from dictionary",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into dictionary ( remarks, ",
        "code, name, chinese_name, ",
        "order_code, create_user_id, ",
        "gmt_create, update_user_id, ",
        "gmt_modified, is_deleted, ",
        "create_org_id)",
        "values (#{remarks,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{chineseName,jdbcType=VARCHAR}, ",
        "#{orderCode,jdbcType=BIGINT}, #{createUserId,jdbcType=VARCHAR}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{updateUserId,jdbcType=VARCHAR}, ",
        "#{gmtModified,jdbcType=TIMESTAMP}, #{isDeleted,jdbcType=TINYINT}, ",
        "#{createOrgId,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Dictionary record);




    @Select({
        "select",
        "id,  remarks, code, name, chinese_name, order_code, create_user_id, ",
        "gmt_create, update_user_id, gmt_modified, is_deleted, create_org_id",
        "from dictionary",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="remarks", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="chinese_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="order_code", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="create_user_id", javaType=Long.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gmt_create", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_user_id", javaType=Long.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="gmt_modified", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="is_deleted", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="create_org_id", javaType=String.class, jdbcType=JdbcType.VARCHAR)})
    Dictionary selectByPrimaryKey(Long id);




    @Update({
        "update dictionary",
        "set ",
          "remarks = #{remarks,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "chinese_name = #{chineseName,jdbcType=VARCHAR},",
          "order_code = #{orderCode,jdbcType=BIGINT},",
          "create_user_id = #{createUserId,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "create_org_id = #{createOrgId,jdbcType=VARCHAR},",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Dictionary record);

    /**
     * 根据条件查询字段
     * @param fieldQueryVO
     * @return
     */
    @Select("<script>"
            + "SELECT id,"
            + "code,"
            + "name,"
            + "remarks,"
            + "chinese_name,"
            + "order_code,"
            +"is_commonly_used "
            + " FROM dictionary "
            + "<where>"
            + "is_deleted != 1"
            + "<if test='fieldQueryVO.chineseName != null'> AND chinese_name LIKE concat('%',#{fieldQueryVO.chineseName}, '%')" + AopConstant.ESCAPE_SQL + "</if>"
            + "<if test='fieldQueryVO.name != null'> AND name LIKE concat('%', #{fieldQueryVO.name} , '%')" + AopConstant.ESCAPE_SQL + "</if>"
            + "</where>"
            + " ORDER BY  order_code,id"
            + "</script>")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_code", property = "orderCode", jdbcType = JdbcType.BIGINT),
            @Result(column = "remarks", property = "remarks", jdbcType = JdbcType.VARCHAR),
            @Result(column = "chinese_name", property = "chineseName", jdbcType = JdbcType.VARCHAR)
    })
    List<DictionaryResult> getFields(@Param("fieldQueryVO") DictionaryQuery fieldQueryVO);


    //根据id查询字段
    @Select("SELECT *" +
            " FROM dictionary WHERE  is_deleted != 1;")
    List<DictionaryResult> findAll();

    /**
     * 新增字段
     * @param fieldCreateVO
     * @param createTime
     * @param baseRequestVo
     * @return
     */
    @Insert("insert into dictionary " +
            "(" +
            "code, " +
            "name, " +
            "chinese_name, " +
            "remarks, " +
            "order_code, " +
            "create_user_id, " +
            "gmt_create , " +
            "create_org_id, " +
            "is_deleted) " +
            "VALUES " +
            "(" +
            "#{fieldCreateVO.code}, " +
            "#{fieldCreateVO.name}, " +
            "#{fieldCreateVO.chineseName}, " +
            "#{fieldCreateVO.remarks}, " +
            "#{fieldCreateVO.orderCode}, " +
            "#{baseRequestVo.requestUserId}, " +
            "#{createTime}, " +
            "#{baseRequestVo.requestOrgId}, " +
            "0);")
    int addField(@Param("fieldCreateVO") DictionaryAdd fieldCreateVO,
                 @Param("createTime") Timestamp createTime,
                 @Param("baseRequestVo") BaseRequestVo baseRequestVo);

    @Insert("insert into dictionary_relation " +
            "(" +
            "name, " +
            "chinese_name, " +
            "create_user_id, " +
            "gmt_create , " +
            "create_org_id, " +
            "is_deleted) " +
            "VALUES " +
            "(" +
            "#{fieldCreateVO.name}, " +
            "#{fieldCreateVO.chineseName}, " +
            "#{baseRequestVo.requestUserId}, " +
            "#{createTime}, " +
            "#{baseRequestVo.requestOrgId}, " +
            "0);")
    int insertField(@Param("fieldCreateVO") DictionaryAdd fieldCreateVO,
                 @Param("createTime") Timestamp createTime,
                 @Param("baseRequestVo") BaseRequestVo baseRequestVo);

    /***
     * 删除字段
     * @param
     * @param delUserId
     * @param delTime
     * @return
     */
    @Delete("update dictionary " +
            "set is_deleted = 1," +
            " gmt_modified=#{delTime}," +
            " update_user_id=#{delUserId} " +
            "where code = #{code}"
    )
    int deleteField(@Param("code") String code,
                           @Param("delUserId") String delUserId,
                           @Param("delTime") Date delTime);

    @Delete("update dictionary_relation " +
            "set is_deleted = 1," +
            " gmt_modified=#{delTime}," +
            " update_user_id=#{delUserId} " +
            "where id = #{id}"
    )
    int deleteRelationField(@Param("id") int id,
                    @Param("delUserId") String delUserId,
                    @Param("delTime") Date delTime);

    @Select({"select count(*) from dictionary where is_deleted = 0 and name = #{name} "})
    int findChild(String name);

    @Select({"select name from dictionary_relation where id = #{id}"})
    String findName(int id);
    /**
     * 修改字段
     * @param fieldUpdateVO
     * @param requestUserId
     * @param updateTime
     * @return
     */
    @Update("update dictionary set " +
            "remarks = #{fieldUpdateVO.remarks}, " +
            "update_user_id = #{requestUserId}, " +
            "gmt_modified = #{updateTime} " +
            "where code = #{fieldUpdateVO.code}")
    int updateField(@Param("fieldUpdateVO") DictionaryUpdate fieldUpdateVO,
                           @Param("requestUserId") String requestUserId,
                           @Param("updateTime") Timestamp updateTime);

    /**
     * 根据条件查询字段
     * @param fieldQueryVO
     * @param
     * @return
     */
    @Select("<script>"
            + "SELECT id,"
            + "code,"
            + "name,"
            + "remarks,"
            + "chinese_name,"
            + "order_code"
            + " FROM dictionary "
            + "<where>"
            + "is_deleted != 1"
            + "<if test='fieldQueryVO.chineseName != null'> AND chinese_name LIKE concat('%',#{fieldQueryVO.chineseName}, '%')</if>"
            + "<if test='fieldQueryVO.name != null'> AND name LIKE concat('%', #{fieldQueryVO.name} , '%')</if>"
            + "</where>"
            + " ORDER BY  id"
            + "</script>")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_code", property = "orderCode", jdbcType = JdbcType.BIGINT),
            @Result(column = "remarks", property = "remarks", jdbcType = JdbcType.VARCHAR),
            @Result(column = "chinese_name", property = "chineseName", jdbcType = JdbcType.VARCHAR)
    })
    List<DictionaryResult> getFieldsDict(@Param("fieldQueryVO") DictionaryQuery fieldQueryVO);


    @Select("<script>"
            + "SELECT id,"
            + "code,"
            + "name,"
            + "remarks,"
            + "chinese_name,"
            + "order_code"
            + " FROM dictionary "
            + "<where>"
            + "is_deleted != 1"
            + "<if test='fieldQueryVO.chineseName != null'> AND remarks LIKE concat('%',#{fieldQueryVO.chineseName}, '%')" + AopConstant.ESCAPE_SQL + "</if>"
            + "<if test='fieldQueryVO.name != null'> AND name LIKE concat('%', #{fieldQueryVO.name} , '%')" + AopConstant.ESCAPE_SQL + "</if>"
            + "</where>"
            + " group by name "
            + "</script>")
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "code", property = "code", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_code", property = "orderCode", jdbcType = JdbcType.BIGINT),
            @Result(column = "remarks", property = "remarks", jdbcType = JdbcType.VARCHAR),
            @Result(column = "chinese_name", property = "chineseName", jdbcType = JdbcType.VARCHAR)
    })
    List<DictionaryResult> getFieldsDictSame(@Param("fieldQueryVO") DictionaryQuery fieldQueryVO);


    @Select("<script>"
            + "SELECT id,"
            + "name,"
            + "chinese_name, "
            + "is_commonly_used "
            + " FROM dictionary_relation "
            + "<where>"
            + "is_deleted != 1"
            + "<if test='fieldQueryVO.chineseName != null'> AND chinese_name LIKE concat('%',#{fieldQueryVO.chineseName}, '%')" + AopConstant.ESCAPE_SQL + "</if>"
            + "<if test='fieldQueryVO.name != null'> AND name LIKE concat('%', #{fieldQueryVO.name} , '%')" + AopConstant.ESCAPE_SQL + "</if>"
            + "</where>" +
            " group by name "
            + "</script>")
    List<Relation> selectFieldsDictSame(@Param("fieldQueryVO") DictionaryQuery fieldQueryVO);
    /**
     * 根据id查询字段
     * @param
     * @param baseRequestVo
     * @return
     */
    @Select("SELECT id," +
            "code," +
            "order_code," +
            "name," +
            "remarks," +
            "chinese_name" +
            " FROM dictionary WHERE  is_deleted != 1" +
            " AND code = #{code};")
    DictionaryResult getFieldsById(@Param(value = "code") String code,
                                            @Param("baseRequestVo") BaseRequestVo baseRequestVo);


    @Select("SELECT id," +
            "code," +
            "order_code," +
            "name," +
            "remarks," +
            "chinese_name" +
            " FROM dictionary WHERE  is_deleted != 1" +
            " AND code = #{code};")
    DictionaryResult getFieldsByCode(@Param(value = "code") String code);

    @Select("SELECT " +
            "name," +
            "chinese_name " +
            " FROM dictionary_relation WHERE  is_deleted != 1" +
            " AND id = #{id};")
    DictionaryAdd getNameAndChineseName(@Param(value = "id") String id);

}