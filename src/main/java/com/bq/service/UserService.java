package com.bq.service;

import com.bq.dao.UserInfoMapper;
import com.bq.dao.UserMapper;
import com.bq.entity.User;
import com.bq.entity.UserInfo;
import com.googlecode.ehcache.annotations.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * test
 * Created by wuyunfeng on 16/9/19.
 */

@Service("userService")
public class UserService {

    private final
    UserInfoMapper userInfoMapper;

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserInfoMapper userInfoMapper,
                       UserMapper userMapper) {
        this.userInfoMapper = userInfoMapper;
        this.userMapper = userMapper;
    }

    public UserInfo getUserById(int userId) {
        // TODO Auto-generated method stub
        return this.userInfoMapper.selectByPrimaryKey(userId);
    }

    @Cacheable(cacheName = "testCache")
    public User select(int userId) {
        return this.userMapper.select(userId);
    }

    public User find(String loginName) {
        return this.userMapper.find(loginName);
    }

}
