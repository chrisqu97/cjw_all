package com.cjw.Dao.Mapper;

import com.cjw.Dao.Entity.StaticData;
import com.cjw.Dao.Entity.StaticDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaticDataMapper {
    int countByExample(StaticDataExample example);

    int deleteByExample(StaticDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StaticData record);

    int insertSelective(StaticData record);

    List<StaticData> selectByExample(StaticDataExample example);

    StaticData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StaticData record, @Param("example") StaticDataExample example);

    int updateByExample(@Param("record") StaticData record, @Param("example") StaticDataExample example);

    int updateByPrimaryKeySelective(StaticData record);

    int updateByPrimaryKey(StaticData record);
}