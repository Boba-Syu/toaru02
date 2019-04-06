package com.hunau.mapper;

import com.hunau.entity.MagicUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MI on 2019/2/1.
 * 对表stu_m的映射
 */
@Repository
public interface MagicUserMapper {

    @Select("SELECT cname, csex, cschool, clevel, cpower, cgrade " +
            "FROM stu_c WHERE cname = #{cname}")
    public MagicUser select(String cname);

    @Select("SELECT cname, csex, cschool, clevel, cpower, cgrade FROM stu_c WHERE cname " +
            "like CONCAT('%',#{name},'%') " +
            "or csex like CONCAT('%',#{name},'%') " +
            "or cschool like CONCAT('%',#{name},'%') " +
            "or clevel like CONCAT('%',#{name},'%') " +
            "or cpower like CONCAT('%',#{name},'%') " +
            "or cgrade like CONCAT('%',#{name},'%')")
    public List<MagicUser> search(String name);

    @Insert("INSERT INTO stu_c(cname,csex,cschool,clevel,cpower,cgrade) " +
            "VALUES(#{cname}, #{csex}, #{cschool}, #{clevel}, #{cpower}, #{cgrade})")
    public int insert(MagicUser magicUser);

    @Update("UPDATE stu_c " +
            "SET csex = #{n}, cschool = #{n}, clevel = #{n}, cpower = #{n}, cgrade = #{n} " +
            "WHERE cname =#{cname}")
    public int update(MagicUser magicUser);

    @Delete("DELETE FROM stu_c WHERE cname = #{cname}")
    public int delete(String cname);

    @Select("SELECT cname, csex, cschool, clevel, cpower, cgrade FROM stu_c")
    public List<MagicUser> slowAll();
}
