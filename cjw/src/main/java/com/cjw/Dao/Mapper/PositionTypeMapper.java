package com.cjw.dao.mapper;

import com.cjw.dao.entity.PositionType;
import com.cjw.dao.entity.PositionTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionTypeMapper {
    int countByExample(PositionTypeExample example);

    int deleteByExample(PositionTypeExample example);

    int deleteByPrimaryKey(Integer positionTypeId);

    int insert(PositionType record);

    int insertSelective(PositionType record);

    List<PositionType> selectByExample(PositionTypeExample example);

    PositionType selectByPrimaryKey(Integer positionTypeId);

    int updateByExampleSelective(@Param("record") PositionType record, @Param("example") PositionTypeExample example);

    int updateByExample(@Param("record") PositionType record, @Param("example") PositionTypeExample example);

    int updateByPrimaryKeySelective(PositionType record);

    int updateByPrimaryKey(PositionType record);
}