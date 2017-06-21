package com.bq.dao;

import com.bq.entity.Role;

import java.util.List;

/**
 * Created by wuyunfeng on 16/9/20.
 */
public interface UserRoleMapper {

    List<Role> getUserRole(Integer userId);

}
