package com.bq.service;

import com.bq.dao.PermissionMapper;
import com.bq.entity.Permission;
import com.bq.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuyunfeng on 16/9/20.
 */
@Service
public class PermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    public List<Permission> getRolePermission(Role role) {
        return permissionMapper.getRolePermission(role.getId());
    }

}
