package com.cjw.dao.mapper;

import com.cjw.dao.entity.SendFile;
import com.cjw.dao.entity.SendFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SendFileMapper {
    int countByExample(SendFileExample example);

    int deleteByExample(SendFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SendFile record);

    int insertSelective(SendFile record);

    List<SendFile> selectByExample(SendFileExample example);

    SendFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SendFile record, @Param("example") SendFileExample example);

    int updateByExample(@Param("record") SendFile record, @Param("example") SendFileExample example);

    int updateByPrimaryKeySelective(SendFile record);

    int updateByPrimaryKey(SendFile record);
}