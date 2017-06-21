package com.bq.dao;

import com.bq.entity.UserInfo;

public interface UserInfoMapper {

    UserInfo selectByPrimaryKey(Integer id);
}