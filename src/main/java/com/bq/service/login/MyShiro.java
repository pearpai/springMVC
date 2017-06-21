package com.bq.service.login;

import com.bq.entity.Permission;
import com.bq.entity.Role;
import com.bq.entity.User;
import com.bq.service.PermissionService;
import com.bq.service.UserRoleService;
import com.bq.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wuyunfeng on 16/9/20.
 */
@Service
@Transactional
public class MyShiro extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        // 获取用登录时输入的用户名
        String loginName = (String) principals.fromRealm(getName()).iterator().next();

        // 到数据库查询是否有此对象
        User user = userService.find(loginName);

        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            // 获取用户角色
            List<Role> roles = userRoleService.getUserRole(user);
            for (Role role : roles) {
                List<Permission> permissions = permissionService.getRolePermission(role);
                for (Permission permission : permissions) {
                    info.addStringPermission(permission.getPermissionname());
                }
            }
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken pToken = (UsernamePasswordToken) token;
        //查出是否有此用户
        User user = userService.find(pToken.getUsername());
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
        }
        return null;
    }
}
