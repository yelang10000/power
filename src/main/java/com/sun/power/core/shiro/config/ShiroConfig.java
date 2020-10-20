package com.sun.power.core.shiro.config;



import com.sun.power.core.shiro.filter.PowerSunFilter;
import com.sun.power.core.shiro.oauth.ShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : 贾涛
 * @date : 2019/3/29  17:19
 */
@Configuration
public class ShiroConfig {

        @Value("${redis.host}")
        private String redisHost;

        @Value("${redis.port}")
        private String redisPort;
        @Value("${redis.password}")
        private String password;

        @Value("${redis.timeout}")
        private int timeout;

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        /**
         * 默认的登陆访问url
         */
         bean.setLoginUrl("/login");

        /**
         * 没有权限跳转的url
         */
        bean.setUnauthorizedUrl("/common/unauthorize");


        /**
         * 覆盖默认的user拦截器(默认拦截器解决不了ajax请求 session超时的问题,若有更好的办法请及时反馈作者)
         */
		 HashMap<String, Filter> myFilters = new LinkedHashMap<String, Filter>();
         myFilters.put("user", new PowerSunFilter());
         bean.setFilters(myFilters);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 拦截index接口，authc表示需要认证才能访问
        filterChainDefinitionMap.put("/index", "authc");
        // anon表示不拦截
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/loginBackEnd", "anon");
        filterChainDefinitionMap.put("/verify-code", "anon");
        filterChainDefinitionMap.put("/verificationForget/**", "anon");
        filterChainDefinitionMap.put("/loginToApi", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/static/**/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/socket/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");

        filterChainDefinitionMap.put("/swagger-ui/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**/**", "anon");
        filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/**", "anon");
        filterChainDefinitionMap.put("/callback", "anon");
        filterChainDefinitionMap.put("/appLogin", "anon");
        filterChainDefinitionMap.put("/vsersionsmp/api/**", "anon");
        filterChainDefinitionMap.put("/loginById", "anon");
        filterChainDefinitionMap.put("/**/version/**", "anon");
        filterChainDefinitionMap.put("/v3/**", "anon");
        filterChainDefinitionMap.put("/logout", "anon");
        filterChainDefinitionMap.put("/loginUser", "anon");
        // 指定admin接口只允许admin角色的用户访问
        filterChainDefinitionMap.put("/admin", "roles[admin]");
        // 用户在登录后可以访问所有的接口
        filterChainDefinitionMap.put("/**", "user");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return bean;
    }

    /**
     * 安全管理器
     */
//    @Bean("securityManager")
//    public DefaultWebSecurityManager securityManager() {
//        return new DefaultWebSecurityManager();
//
//    }
    @Bean
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(false);
        sessionManager.setSessionIdUrlRewritingEnabled(false);

        return sessionManager;
    }
    @Bean("securityManager")
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(shiroRealm());
        // 自定义缓存实现 使用redis
       // securityManager.setCacheManager(cacheManager());
        // 自定义session管理 使用redis
       // securityManager.setSessionManager(sessionManager());
       // securityManager.setRememberMeManager(null);
        return securityManager;
    }

    @Bean("shiroRealm")
    public ShiroRealm shiroRealm() {
        // 设置自定义的Realm

        return  new  ShiroRealm();
    }

    /**
     * 启用shrio授权注解拦截方式，AOP式方法级权限检查
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
                new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        // 设置代理类
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);

        return creator;
    }
}
