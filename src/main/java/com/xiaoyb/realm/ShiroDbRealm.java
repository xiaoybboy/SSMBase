package com.xiaoyb.realm;

import com.xiaoyb.domain.Role;
import com.xiaoyb.domain.User;
import com.xiaoyb.service.UserService;
import com.xiaoyb.utils.CipherUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroDbRealm extends AuthorizingRealm {
    private static final String ALGORITHM = "MD5";
    private static Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);
    @Autowired
    private UserService userService;

    /**
     * 登陆验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        System.out.println(token.getUsername());
        User user = userService.findUserByLoginName(token.getUsername());
        // MD5加密
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getName(), CipherUtil.generatePassword(user.getPassword()),
                    getName());
        } else {
            throw new AuthenticationException();
        }
    }

    /**
     * 登陆成功之后，进行角色和权限验证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取登录时输入的用户名
        String loginName = (String) principals.fromRealm(getName()).iterator().next();
        // 到数据库查是否有此对象
        User user = userService.findUserByLoginName(loginName);
        if (user != null) {
            // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 用户的角色集合
            info.setRoles(user.getRolesName());// 数据库中查询找的用户的角色
            // 用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
            List<Role> roleList = user.getRoleList();
            for (Role role : roleList) {
                info.addStringPermissions(role.getPermissionsName());
            }
            return info;
        }
        return null;
    }

    /**
     * 清除所有用户授权信息缓存.
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除所有用户授权信息缓存.
     */
    public void clearAllCachedAuthorizationInfo() {
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
        if (cache != null) {
            for (Object key : cache.keys()) {
                cache.remove(key);
            }
        }
    }
}
