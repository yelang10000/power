package com.sun.power.core.shiro.factory.Impl;




import com.sun.power.core.shiro.ShiroUser;
import com.sun.power.core.shiro.factory.IShiro;
import com.sun.power.core.utils.SpringContextHolder;
import com.sun.power.modules.system.dictionary.dao.DictionaryMapper;
import com.sun.power.modules.system.organization.dao.OrganizationMapper;
import com.sun.power.modules.system.role.dao.RoleUserMapper;
import com.sun.power.modules.system.user.dao.UserMapper;

import com.sun.power.modules.system.user.dto.UserLogin;
import com.sun.power.modules.system.user.entity.User;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@DependsOn("springContextHolder")
public class ShiroFactroy implements IShiro {

    @Autowired
    private UserMapper userMapper;



    @Autowired
    private DictionaryMapper dictionaryMapper;


    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;






    public static IShiro me() {
        return SpringContextHolder.getBean(IShiro.class);
    }

    @Override
    public User user(String account) {


        User user = userMapper.findByUserName(account);

        UserLogin userLogin=new UserLogin();
        userLogin.setId(user.getId());
        userLogin.setDateOfLogin(new Date());
        userMapper.updateUserLogin(userLogin);
        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
//        // 账号被冻结
//        if (user.getStatus() != ManagerStatus.OK.getCode()) {
//            throw new LockedAccountException();
//        }
        return user;
    }


    @Override
    public ShiroUser shiroUser(User user) {
        ShiroUser shiroUser = new ShiroUser();


        shiroUser.setId(user.getId());
        shiroUser.setAccount(user.getUserName());
        shiroUser.setName(user.getRealName());
        shiroUser.setCreateOrgId(user.getCreateOrgId());
        shiroUser.setOrganizationId(user.getOrganizationId());
        shiroUser.setDictRank(organizationMapper.findDictRank(user.getOrganizationId()));
        shiroUser.setOrganizationName(organizationMapper.findById(user.getOrganizationId()).getOrganizationName());
//         Integer[] roleArray = Convert.toIntArray(user.getRoleid());
       // String[] roleArray = Convert.toStrArray(user.getRoleId());

        String[] roleArray=  roleUserMapper.selectRoleByUserId(user.getId());
        List<String> roleList = new ArrayList<String>();
        List<String> roleNameList = new ArrayList<String>();
        for (String roleId : roleArray) {
            roleList.add(roleId);
            roleNameList.add(ConstantFactory.me().getSingleRoleName(roleId));
        }
        shiroUser.setRoleList(roleList);
        shiroUser.setRoleNames(roleNameList);

        return shiroUser;
    }



    @Override
    public List<String> findPermissionsByRoleId(String roleId) {
        return ConstantFactory.me().getMenuByRoleId(roleId);
    }


    @Override
    public String findRoleNameByRoleId(String roleId) {

        return ConstantFactory.me().getSingleRoleTip(roleId);
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
        String credentials = user.getPassword();

        // 密码加盐处理
        //String source = user.getSalt();
       // ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, realmName);
    }




}
