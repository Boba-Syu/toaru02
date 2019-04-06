package com.hunau.mapper;

import com.hunau.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MI on 2019/3/4.
 */
@Repository
public interface MessageMapper {
    @Select("SELECT name, time, text FROM stu_message ORDER BY time")
    public List<Message> select();

    @Insert("INSERT INTO stu_message(name, time, text) VALUES( #{name}, #{time}, #{text} )")
    public int insert(Message message);
}
