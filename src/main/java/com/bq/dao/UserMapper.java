package com.bq.dao;

import com.bq.entity.User;

/**
 * Created by wuyunfeng on 16/9/20.
 */
public interface UserMapper {
     User select(Integer id);

     User find(String username);
}
