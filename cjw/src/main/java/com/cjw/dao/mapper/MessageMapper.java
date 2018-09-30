package com.cjw.dao.mapper;

import com.cjw.dao.entity.Message;
import com.cjw.dao.entity.MessageExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper {
    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer messageId);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);


    @Select("select * from message where position_id =#{positionId} and (user_id=#{userId} or accepter_id =#{userId})and state =1 order by create_time;")
    List<Message> findByPosition(@Param("positionId") Integer positionId, @Param("userId") Integer userId);
}