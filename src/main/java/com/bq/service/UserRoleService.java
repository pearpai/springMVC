package com.bq.service;

import com.bq.dao.UserRoleMapper;
import com.bq.entity.Role;
import com.bq.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuyunfeng on 16/9/20.
 */
@Service
public class UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    public List<Role> getUserRole(User user){
        return userRoleMapper.getUserRole(user.getId());
    }

}
