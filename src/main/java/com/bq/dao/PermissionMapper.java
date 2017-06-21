package com.bq.dao;

import com.bq.entity.Permission;

import java.util.List;

/**
 * Created by wuyunfeng on 16/9/20.
 */
public interface PermissionMapper {
    List<Permission> getRolePermission(Integer roleId);
}
