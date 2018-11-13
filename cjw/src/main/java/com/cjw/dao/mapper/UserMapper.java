package com.cjw.dao.mapper;

import com.cjw.dao.entity.User;
import com.cjw.dao.entity.UserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select count(*) from user where user_id =#{userId} and session_key=#{sessionKey}")
    int ifExistUser(@Param("userId") Integer userId, @Param("sessionKey") String sessionKey);

    @Select("select user_id,user_name from user")
    List<User> getUserIdAndUserName();

    @Select("select user_id from user")
    List<Integer> getAllUserIds();
}