package com.sun.power.modules.system.dictionary.service.impl;

import com.sun.power.core.aop.mysql.MysqlQueryFieldHandleAspect;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;

import com.sun.power.core.exception.PowerException;
import com.sun.power.core.utils.UUIDGenerator;
import com.sun.power.modules.system.dictionary.dao.DictionaryMapper;
import com.sun.power.modules.system.dictionary.model.Dictionary;
import com.sun.power.modules.system.dictionary.service.DictionaryManagementService;
import com.sun.power.modules.system.dictionary.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * @author : 贾涛
 * @date : 2019/4/22  14:25
 */
@Slf4j
@Service
public class DictionaryManagementServiceImpl implements DictionaryManagementService {

    @Autowired
    DictionaryMapper dictionaryMapper ;

    /**
     * 新增字典
     * @param requestVo
     * @param baseRequestVo
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void insertItem(DictionaryAdd requestVo, BaseRequestVo baseRequestVo) {
        //根据id查询
        DictionaryAdd dictionaryAdd = dictionaryMapper.getNameAndChineseName(requestVo.getId());
        requestVo.setChineseName(dictionaryAdd.getChineseName());
        requestVo.setName(dictionaryAdd.getName());
        requestVo.setCode(UUIDGenerator.generate());

        int r = dictionaryMapper.addField(requestVo, nowTime(), baseRequestVo);
        if (r > 0) {
            log.info("新增成功");
        } else {
            log.error("新增失败");
        }
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void insertRelation(DictionaryAdd requestVo, BaseRequestVo baseRequestVo){
        dictionaryMapper.insertField(requestVo,nowTime(),baseRequestVo);
    }



    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteByIds(DictionaryDelete requestVo, BaseRequestVo baseRequestVo) {
        String delUserId = baseRequestVo.getRequestUserId();

        for (int i = 0; i < requestVo.getIdsDictionary().length; i++) {


            String fieldId = requestVo.getIdsDictionary()[i];
            log.info("fieldId = " + fieldId);
            int r = dictionaryMapper.deleteField(fieldId, delUserId, nowTime());

        }

    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteRelationByIds(DictionaryDelete requestVo, BaseRequestVo baseRequestVo) {
        String delUserId = baseRequestVo.getRequestUserId();

        int id[] = requestVo.getIds();
        int j = 0;
        for (int i = 0; i < id.length; i++) {
            int fieldId = id[i];
            log.info("fieldId = " + fieldId);
            if(dictionaryMapper.findChild(dictionaryMapper.findName(fieldId)) != 0 ){
                throw new PowerException("该字典下存在字段，请删除字段后重试");
            }
            int r = dictionaryMapper.deleteRelationField(fieldId, delUserId, nowTime());
            if (r > 0) {
                j++;
            } else {
                log.error("第" + fieldId + "条记录删除失败");
            }
        }
        if (j == id.length) {
            log.info("删除成功");
        } else {
            log.error("删除失败");
        }
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void putItemById(String userId, DictionaryUpdate requestVo, BaseRequestVo baseRequestVo) {
        String requestUserId = baseRequestVo.getRequestUserId();
        int r = 0;
        r = dictionaryMapper.updateField(requestVo, requestUserId, nowTime());
        if (r > 0) {
            log.info("修改成功！");
        } else {
            log.error("修改失败！");
            throw new PowerException("修改失败");

        }
    }

    @Override
    public PageBean<DictionaryResult> findItems(DictionaryQuery requestVo) {
        return null;
    }


    @MysqlQueryFieldHandleAspect
    public List<DictionaryResult> findItems1(DictionaryQuery fieldQueryVO) {
        log.info("start find list......");
        if (null == fieldQueryVO.getChineseName() || "".equals(fieldQueryVO.getChineseName())) {
            fieldQueryVO.setChineseName(null);
        }

        List<DictionaryResult> fieldVOList = new ArrayList<>();
        //根据不同查询类型返回不同结果
//        if ("dict".equalsIgnoreCase(fieldQueryVO.getQueryType())) {
//            List<DictionaryResult> fieldMapperList = dictionaryMapper.getFieldsDictSame(fieldQueryVO);
//            fieldVOList.addAll(fieldMapperList);
//        } else {
            List<DictionaryResult> fieldMapperList = dictionaryMapper.getFields(fieldQueryVO);
            fieldVOList.addAll(fieldMapperList);
//        }

//        Integer countNum = fieldVOList.size();
//        PageBean<DictionaryResult> pageData = new PageBean<>(fieldQueryVO.getCurrentPage(), fieldQueryVO.getPageSize(), countNum);
//        pageData.setItems(fieldVOList);
        return fieldVOList;
    }

    //查询中文名关系表
    @MysqlQueryFieldHandleAspect
    public PageBean<Relation> selectItems(DictionaryQuery fieldQueryVO) {
        List<Relation> fieldVOList = dictionaryMapper.selectFieldsDictSame(fieldQueryVO);
        Integer countNum = fieldVOList.size();
        PageBean<Relation> pageData = new PageBean<>(fieldQueryVO.getCurrentPage(), fieldQueryVO.getPageSize(), countNum);
        pageData.setItems(fieldVOList);
        return pageData;
    }

    @Override
    public DictionaryResult findItemById(String userId, BaseRequestVo baseRequestVo) {
        return null;
    }


    public DictionaryResult findById(String code, BaseRequestVo baseRequestVo) {
        log.info("find start ...");
        DictionaryResult result = dictionaryMapper.getFieldsById(code, baseRequestVo);
        if (null == result) {
            throw new PowerException("服务异常");
        }
        log.info("查询的信息id为 ：" + result.getId());
        log.info("find end ...");
        return result;
    }

    /**
     * 获取当前时间
     * @return
     */
    public Timestamp nowTime() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);
        return time;
    }


}
