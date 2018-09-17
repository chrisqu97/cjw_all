package com.cjw.dao.mapper;

import com.cjw.dao.entity.File;
import com.cjw.dao.entity.FileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileMapper {
    int countByExample(FileExample example);

    int deleteByExample(FileExample example);

    int deleteByPrimaryKey(Integer fileId);

    int insert(File record);

    int insertSelective(File record);

    List<File> selectByExampleWithBLOBs(FileExample example);

    List<File> selectByExample(FileExample example);

    File selectByPrimaryKey(Integer fileId);

    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    int updateByExampleWithBLOBs(@Param("record") File record, @Param("example") FileExample example);

    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKeyWithBLOBs(File record);

    int updateByPrimaryKey(File record);
}