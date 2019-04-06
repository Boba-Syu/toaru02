package com.hunau.service;

import com.hunau.entity.MagicUser;
import com.hunau.mapper.MagicUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MI on 2019/2/1.
 * 连接MagicUserMapper和MagicUserController的服务层
 */
@Repository
public class magicUserService {
    @Autowired
    MagicUserMapper userMapper;

    public MagicUser select(String cname) {
        return userMapper.select(cname);
    }

    public List<MagicUser> search(String cname) {
        return userMapper.search(cname);
    }

    public List<MagicUser> showAll() {
        return userMapper.slowAll();
    }

    public int insert(MagicUser user) {
        return userMapper.insert(user);
    }

    public int update(MagicUser user) {
        return userMapper.update(user);
    }

    public int delete(String cname) {
        return userMapper.delete(cname);
    }
}
