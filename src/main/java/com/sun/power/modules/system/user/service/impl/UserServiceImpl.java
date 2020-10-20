package com.sun.power.modules.system.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.power.core.aop.mysql.MysqlQueryFieldHandleAspect;
import com.sun.power.core.common.entity.BaseDeleteQueryVO;
import com.sun.power.core.common.entity.BaseDeleteRequestBodyVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;
import com.sun.power.core.exception.PowerException;
import com.sun.power.core.utils.MD5Util;
import com.sun.power.modules.system.user.dao.UserMapper;
import com.sun.power.modules.system.user.dto.AddUserVo;
import com.sun.power.modules.system.user.dto.QueryUserVo;
import com.sun.power.modules.system.user.dto.UpdatePasswordVo;
import com.sun.power.modules.system.user.dto.UpdateUserVo;
import com.sun.power.modules.system.user.entity.User;
import com.sun.power.modules.system.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author 贾涛
 * @Date 2020/10/19 16:07
 * @Version 1.0
 */
@Slf4j
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    private  String resentPassword = MD5Util.MD5("123456");
    @Override
    public boolean phonenumberOnlyCheckout(String phonenumber) {
        boolean isExist = true;
        List<String> phonenumberList = userMapper.phoneNumberList(phonenumber);
        for(String getPhonenumber : phonenumberList){
            if(phonenumber.equals(getPhonenumber)){
                isExist = false;
                throw new PowerException("电话号码已存在");
            }
        }
        return isExist;
    }

    @Override
    public boolean idCardOnlyCheckout(String idCard) {
        boolean isExist = true;
        List<String> idCardList = userMapper.idCardList();
        for(String card : idCardList){
            if(idCard.equals(card)){
                isExist = false;
                throw new PowerException("身份证已存在");
            }
        }
        return isExist;
    }

    @Override
    public void resetPassword(String userId) {
        String password = resentPassword;
        userMapper.resetPassword(userId,password);
    }

    @Override
    public void updatePassword(UpdatePasswordVo updatePasswordVo, BaseRequestVo baseRequestVo) {
        updatePasswordVo.setUpdateUserId(baseRequestVo.getRequestUserId());
        String rawpassword = userMapper.selectByPrimaryKey(updatePasswordVo.getId()).getPassword();
        if(rawpassword.equals(updatePasswordVo.getNewPassword())){
            throw new PowerException("新密码和原密码相同");
        }
        if((updatePasswordVo.getRawPassword().equals(rawpassword)) ){
            userMapper.checkoutPassword(updatePasswordVo);
        }else{
            throw new PowerException("原密码不正确");
        }
    }

    @Override
    public void resetPasswordForAnalysis(String userId) {

    }

    @Override
    public void updatePasswordForAnalysis(UpdatePasswordVo updatePasswordVo, BaseRequestVo baseRequestVo) {

    }

    /***
     * 添加工作人员
     * @param requestVo
     * @param baseRequestVo
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void insertItem(AddUserVo requestVo, BaseRequestVo baseRequestVo) {
        requestVo.setPassword(resentPassword);
        if(requestVo.getUserName() != null && requestVo.getDictSex() != null
                && requestVo.getPhoneNumber() != null && requestVo.getOrganizationId() != null
                && requestVo.getOrganizationId().length()>0 && !("".equals(requestVo.getOrganizationId()))
                && requestVo.getRoleId() != null && requestVo.getUserName() != null && requestVo.getIdCard() != null) {
            userMapper.insert(requestVo);

        }else{
            throw new PowerException("输入必填项");
        }
    }

    /***
     * 批量删除工作人员
     * @param requestVo
     * @param baseRequestVo
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void deleteByIds(BaseDeleteRequestBodyVO requestVo, BaseRequestVo baseRequestVo) {
        if(requestVo.getIds().size() == 0){
            throw new PowerException("请选择需删除项");
        }else {
            BaseDeleteQueryVO baseDeleteQueryVO = new BaseDeleteQueryVO();
            baseDeleteQueryVO.setGmtModified(new Date());
            baseDeleteQueryVO.setIds(requestVo.getIds());
            baseDeleteQueryVO.setUpdateUserId(baseRequestVo.getRequestUserId());
            userMapper.deleteUserByIds(baseDeleteQueryVO);
        }
    }

    /***
     * 编辑工作人员
     * @param requestVo
     * @param baseRequestVo
     * @return
     */
    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void putItemById(String userId, UpdateUserVo requestVo, BaseRequestVo baseRequestVo) {
        requestVo.setId(userId);
        if(!userMapper.selectByPrimaryKey(userId).getPhoneNumber().equals(requestVo.getPhoneNumber())){
            phonenumberOnlyCheckout(requestVo.getPhoneNumber());
        }
        userMapper.updateUser(requestVo);
        if (requestVo.getRoleId()!=null){
        userMapper.updateRole(requestVo);}
    }

    /***
     * 分页查询列表/按照userName(登陆名称)、realName(姓名)模糊查询
     * @param requestVo
     * @return
     */
    @Override
    @MysqlQueryFieldHandleAspect
    public PageBean<User> findItems(QueryUserVo requestVo) {
        requestVo.setDataAuthSql(requestVo.getDataAuthSql().
                replace("create_org_id", "u.create_org_id"));
        Integer currentPage = requestVo.getCurrentPage();
        Integer pageSize = requestVo.getPageSize();
        Page page = PageHelper.startPage(currentPage == null ? 1 : currentPage,
                pageSize == null ? 10 : pageSize);
        List<User> userList =  userMapper.selectAllUser(requestVo);
        PageBean<User> pageData = new PageBean<>(currentPage == null ? 1 : currentPage, pageSize == null ? 10 : pageSize, new Long(page.getTotal()).intValue());
        pageData.setItems(userList);
        return pageData;
    }

    /***
     * 根据userId查询工作人员所有信息
     * @param userId
     *  @param baseRequestVo
     * @return
     */
    @Override
    public User findItemById(String userId, BaseRequestVo baseRequestVo) {
        if (userId==null){
            throw new PowerException("工作人员id不可为空");
        }
        if (baseRequestVo==null){
            throw new PowerException("基本参数为空");
        }

        User user =  userMapper.selectByPrimaryKey(userId);
        return user;
    }
}
