package com.sun.power.core.shiro.login.service.impl;

import com.sun.power.core.common.constant.SysConstant;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;
import com.sun.power.core.exception.PowerException;
import com.sun.power.core.shiro.ShiroKit;
import com.sun.power.core.shiro.ShiroUser;
import com.sun.power.core.shiro.factory.Impl.ConstantFactory;
import com.sun.power.core.shiro.login.dto.UserRedisVo;
import com.sun.power.core.shiro.login.service.LoginService;
import com.sun.power.modules.system.organization.dao.OrganizationMapper;
import com.sun.power.modules.system.role.dao.RoleMapper;
import com.sun.power.modules.system.role.service.RoleService;
import com.sun.power.modules.system.rule.dto.ResultRuleVo;
import com.sun.power.modules.system.user.dao.UserMapper;
import com.sun.power.modules.system.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author 贾涛
 * @Date 2020/10/15 17:07
 * @Version 1.0
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private RedisTemplate<String, UserRedisVo> redisTemplate;

    @Value("${spring.profiles.active}")
    private String active;

    @Autowired
    private UserMapper userMapper ;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private OrganizationMapper organizationMapper ;

    @Override
    public UserRedisVo logIn(HttpServletRequest request, String username, String password, String verifyCode) {
        Subject currentUser = ShiroKit.getSubject();
        //生产环境进行验证码验证
        if (SysConstant.ACTIVE.equalsIgnoreCase(active)){
                //PC登陆 从session中获取验证码
                if (verifyCode==null ||"".equals(verifyCode)){
                    throw new PowerException("验证码为空");
                }
                String key = (String) request.getSession().getAttribute("code");
                if (key == null ){
                    throw new PowerException("请重新获取验证码");
                }
                if (!verifyCode.equalsIgnoreCase(key)) {
                    throw new PowerException("验证码错误");
                }
            }

        /**
         * 用户信息
         */
        User user = userMapper.findByUserName(username);

        if(user==null)
        {
            throw new PowerException("用户名或密码错误！");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
        try {
            currentUser.login(token);
        } catch (LockedAccountException lae) {

            throw new PowerException("用户名已经被锁定不能登录，请与管理员联系！");

        }
        catch (UnknownAccountException e) {

            throw new PowerException("用户名或密码错误！，请检查账号或密码！");

        }
        catch (IncorrectCredentialsException e) {

            throw new PowerException("用户名或密码错误！");

        }
        catch (Exception e) {

            throw new PowerException("用户或密码不正确！");

        }
        if (currentUser.isAuthenticated())
        {
            ShiroUser shiroUser= ShiroKit.getUser();
            Integer isAdmin = roleMapper.selectIsAdminByUserId(user.getId());
            if (isAdmin != null){
                shiroUser.setIsAdmin(isAdmin);
            }else {
                shiroUser.setIsAdmin(0);
            }
            UserRedisVo userRedisVo = generatreToken(shiroUser);
            log.info("登录成功");
            return  userRedisVo;
        }else {
            token.clear();
            throw new PowerException("登录失败！");
        }


    }

    private UserRedisVo generatreToken(ShiroUser shiroUser) {
        //权限信息列表获取
        UserRedisVo userRedisVo = new UserRedisVo();

            for (String roleid : shiroUser.getRoleList()) {
                List<String> list = ConstantFactory.me().getMenuByRoleId(roleid);
                List<ResultRuleVo> ruleVoList = roleService.selectRuleByRoleId(roleid);
                userRedisVo.setAuthorityList(list);
                userRedisVo.setRuleList(ruleVoList);

        }
        //录入用户信息
        userRedisVo.setUserInfo(shiroUser);

        Date date = new Date();
        //token 源字符串
        String tokenStr = shiroUser.getAccount()+ date.toString();
        String loginOkToken = new SimpleHash("md5", tokenStr).toHex();
        //生成数据权限查询sql
        userRedisVo.setDataAuthSql(generateDataAuthSql(userRedisVo));


        /**
         * 录入userRedis
         *
         */
        ValueOperations<String, UserRedisVo> valueops = redisTemplate.opsForValue();

        valueops.set(loginOkToken, userRedisVo, SysConstant.TOKEN_TIMEOUT, TimeUnit.MINUTES);
        userRedisVo.setUsername(shiroUser.getAccount() );
        userRedisVo.setToken(loginOkToken);
        return userRedisVo;
    }

    /**
     * 生成数据权限语句
     * @param userRedisVo
     * @return
     */
    private String generateDataAuthSql(UserRedisVo userRedisVo) {
        //查询组织信息
        //Organization organization = (organizationDao.findById(userRedisVo.getUser().getCreateOrgId()));
        String orgIdString = null;
        //userRedisVo.setOrganizationSearchId(userRedisVo.getOrganization().getId());
         orgIdString =  " AND create_org_id = '" + userRedisVo.getUserInfo().getCreateOrgId() + "'";
        //userRedisVo.setDataAuthSql(" AND create_org_id = '" + userRedisVo.getUserInfo().getCreateOrgId()+"'");
        return  orgIdString;
    }

    @Override
    public void logOut(String token) {


        ShiroKit.getSubject().logout();
        redisTemplate.delete(token);

    }
    @Override
    public void insertItem(Object requestVo, BaseRequestVo baseRequestVo) {

    }

    @Override
    public void deleteByIds(Object requestVo, BaseRequestVo baseRequestVo) {

    }

    @Override
    public void putItemById(String userId, Object requestVo, BaseRequestVo baseRequestVo) {

    }

    @Override
    public PageBean findItems(Object requestVo) {
        return null;
    }

    @Override
    public Object findItemById(String userId, BaseRequestVo baseRequestVo) {
        return null;
    }
}
