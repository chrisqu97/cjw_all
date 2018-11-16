package com.cjw.dao.mapper;

import com.cjw.dao.entity.Position;
import com.cjw.dao.entity.PositionExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PositionMapper {
    int countByExample(PositionExample example);

    int deleteByExample(PositionExample example);

    int deleteByPrimaryKey(Integer positionId);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(Integer positionId);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    @Select("select position_name from position where position_name like #{positionName}")
    List<String> getPositionName(@Param("positionName") String positionName);

    @Select("select position_id from position where position_type =#{positionType}")
    List<Integer> getAllPositionIdsByPositionType(@Param("positionType") Integer positionType);

    @Select("select position_id from position")
    List<Integer> getAllPositionIds();
}