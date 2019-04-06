package com.hunau.mapper;


import com.hunau.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by MI on 2019/2/7.
 * 对应表stu_user的映射
 */
@Repository
public interface UserMapper {

    @Select("SELECT name, pwd FROM stu_user WHERE name = #{name}")
    public User login(String name);

    @Insert("INSERT INTO stu_user(name, pwd) VALUES( #{name}, #{pwd} )")
    public int register(@Param("name") String name, @Param("pwd") String pwd);
}
