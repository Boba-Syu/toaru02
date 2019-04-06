package com.hunau.service;

import com.hunau.entity.User;
import com.hunau.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by MI on 2019/2/7.
 * 连接UserMapping和UserController的服务层
 */
@Repository
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User login(User user) {
        return userMapper.login(user.getName());
    }

    public int register(User user) {
        return userMapper.register(user.getName(), user.getPwd());
    }

}
