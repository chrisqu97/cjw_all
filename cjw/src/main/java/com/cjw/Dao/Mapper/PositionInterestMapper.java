package com.cjw.dao.mapper;

import com.cjw.dao.entity.PositionInterest;
import com.cjw.dao.entity.PositionInterestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionInterestMapper {
    int countByExample(PositionInterestExample example);

    int deleteByExample(PositionInterestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PositionInterest record);

    int insertSelective(PositionInterest record);

    List<PositionInterest> selectByExample(PositionInterestExample example);

    PositionInterest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PositionInterest record, @Param("example") PositionInterestExample example);

    int updateByExample(@Param("record") PositionInterest record, @Param("example") PositionInterestExample example);

    int updateByPrimaryKeySelective(PositionInterest record);

    int updateByPrimaryKey(PositionInterest record);
}