package com.hunau.service;

import com.hunau.entity.Message;
import com.hunau.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MI on 2019/3/4.
 */
@Repository
public class MessageService {
    @Autowired
    MessageMapper messageMapper;

    public List<Message> select() {
        return messageMapper.select();
    }

    public int insert(Message message) {
        return  messageMapper.insert(message);
    }
}
